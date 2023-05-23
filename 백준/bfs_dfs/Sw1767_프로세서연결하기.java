package bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw1767_프로세서연결하기 {
	static int TC, N;
	static int[][] arr;
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static ArrayList<Loc> listZero;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			ArrayList<Loc> list = new ArrayList<>();
			listZero = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) {
						if(i != 0 && j != 0) list.add(new Loc(i, j));
						else listZero.add(new Loc(i, j));
					}
				}
			}
			int[] sel = new int[list.size()];
			for (int i = 0; i < sel.length; i++) {
				sel[i] = i;
			}
//			System.out.println(queue.toString());
			prew(0, sel, new int[list.size()], new boolean[list.size()], list);
		}
	}

	private static void prew(int idx, int[]arr, int[] sel, boolean[] v, ArrayList<Loc> list) {
		if(idx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			int[][] tmp = new int[N][N];
			for (int i = 0; i < listZero.size(); i++) {
				tmp[listZero.get(i).x][listZero.get(i).y] = 1;
			}
			dfs(sel, 0, new boolean[list.size()], list, tmp);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = arr[i];
				prew(idx+1, arr, sel, v, list);
				v[i] = false;
			}
		}
		
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void dfs(int[] sel, int i, boolean[] v, ArrayList<Loc> list, int[][] tmp) {
		v[sel[i]] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = list.get(sel[i]).x + dr[d];
			int nc = list.get(sel[i]).y + dc[d];
			
			if(check(nr, nc) && tmp[nr][nc] != 1) {
				
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N ;
	}

}
