package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class Sw1949_등산로조성3 {
	static int N, K, maxLen, top;
	static int arr[][];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Loc> list;
	static class Loc{
		int x, y;

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr= new int[N][N];
			maxLen = 0;
			top = 0;
			list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					if(top < arr[i][j]) {
						top = arr[i][j];
						list = new ArrayList<>();
						list.add(new Loc(i, j));
					}else if(top == arr[i][j]) list.add(new Loc(i, j));
				}
			}
			
//			System.out.println(list.toString());
			
			
			for (int i = 0; i < list.size(); i++) {
				dfs(list.get(i).x, list.get(i).y, 0, new boolean[N][N], 0);
			}
			
			System.out.println(maxLen);
		}
	}

	private static void dfs(int r, int c, int depth, boolean[][] v, int k) {
		maxLen = Math.max(depth, maxLen);
		
		for (int d = 0; d < 4; d++) {
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(check(nr, nc)) {
				
				// 일단 그 다음껄 깍아 
				arr[nr][nc] -= K;

				arr[nr][nc] += K;
				
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
