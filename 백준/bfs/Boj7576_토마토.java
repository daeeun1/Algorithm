package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj7576_토마토 {
	static int M, N;
	static int[][] arr;
	static Queue<Loc> queue = new LinkedList<>();
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					queue.add(new Loc(i, j));
				}
			}
		}
		
//		System.out.println(queue);
		bfs();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					cnt = 0;
				}
			}
		}
		if(cnt == 0) {
			System.out.println(-1);
		}else {
			System.out.println(cnt -1);
		}
		
	}

	static int cnt = 1;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void bfs() {
		while(!queue.isEmpty()) {
			Loc tmp = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = tmp.x + dr[d];
				int nc = tmp.y + dc[d];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && arr[nr][nc] ==0) {
					cnt = arr[nr][nc] = arr[tmp.x][tmp.y] + 1;
					queue.add(new Loc(nr, nc));
				}
			}
		}
	}

}
