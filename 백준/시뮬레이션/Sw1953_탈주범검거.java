package 시뮬레이션;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] arr;
	static int[][] sel;
	static int[][] dr = {{0}, {1, -1, 0, 0}, {1, -1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {0, -1}}; 
	static int[][] dc = {{0}, {0, 0, -1, 1}, {0, 0}, {1, -1}, {0, 1}, {0, 1}, {0, -1}, {-1, 0}};
	static Queue<Loc> queue;
	static boolean[][] v;
	static class Loc{
		int x, y, depth, d;

		public Loc(int x, int y, int depth, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + ", depth=" + depth + ", d=" + d + "]";
		}

		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][M];
			sel = new int[N][M];
			v = new boolean[N][M];
			queue = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			queue.add(new Loc(R, C, 1, arr[R][C]));
			bfs();
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(sel[i]));
			}
			
		}
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			Loc tmp = queue.poll();
			int r = tmp.x;
			int c = tmp.y;
			v[r][c] = true;
			sel[r][c] = tmp.depth;
			
			for (int i = 0; i < dr[tmp.d].length; i++) {
				int nr = r + dr[tmp.d][i];
				int nc = c + dc[tmp.d][i];
				
				if(check(nr, nc) && !v[nr][nc] && arr[nr][nc] > 0) {
					// 이 안에서 저거 해야함 파이프 받는 거 해야합니다.
					queue.add(new Loc(nr, nc, tmp.depth+1, arr[nr][nc]));
				}
			}
			
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
