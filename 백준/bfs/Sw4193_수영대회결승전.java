package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw4193_수영대회결승전 {
	static int N, min;
	static class Loc{
		int x, y, d, toneido;

		public Loc(int x, int y, int d, int toneido) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.toneido = toneido;
		}

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + ", d=" + d + ", toneido=" + toneido + "]";
		}
		
	}
	static ArrayList<Loc> list;
	static int[][] sea;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			sea = new int[N][N];
			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sea[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 2; i++) {
				list.add(new Loc(sc.nextInt(), sc.nextInt(), 0, 0));
			}
			
			bfs();
			if(min == Integer.MAX_VALUE) System.out.println("#" + tc + " -1");
			else System.out.println("#" + tc + " " +min);
		}
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void bfs() {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(list.get(0).x, list.get(0).y, list.get(0).d, list.get(0).toneido));
		boolean[][] v = new boolean[N][N];
		
		while(!queue.isEmpty()) {
			Loc tmp = queue.poll();
			if(tmp.x == list.get(1).x && tmp.y == list.get(1).y) min = Math.min(min, tmp.d); 
			
			for (int d = 0; d < 4; d++) {
				int nr = tmp.x + dr[d];
				int nc = tmp.y + dc[d];
				if(check(nr, nc) && !v[nr][nc]) {
					if(sea[nr][nc] == 0) {
						v[nr][nc] = true;
						queue.add(new Loc(nr, nc, tmp.d+1, tmp.toneido+1));
					}
					
					if(sea[nr][nc] == 2 && tmp.toneido%3 == 2) {
						v[nr][nc] = true;
						queue.add(new Loc(nr, nc, tmp.d+1, tmp.toneido+1));
					}
					else if(sea[nr][nc] == 2 && tmp.toneido%3 != 2) {
						queue.add(new Loc(tmp.x, tmp.y, tmp.d+1, tmp.toneido+1));
					}
				}
 			}
			
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}








