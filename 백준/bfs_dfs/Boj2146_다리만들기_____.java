package bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1. 일단 섬을 만듭시다!!!
// 2. 최단 거리 구하기
public class Boj2146_다리만들기_____ {
	static int[][] map;
	static int N;

	static class Loc {
		int x, y, depth;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Loc(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

	}

	static Queue<Loc> island = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 2;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, cnt++);
				}
			}
		}

		int result = Integer.MAX_VALUE;
		print();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					bfs2(i, j);
					result = Math.min(result, min);
				}
			}
		}

		System.out.println(result);
		
	}
	static boolean[][] v; 
	static int[][] copy;
	static int min = Integer.MAX_VALUE;
	private static void bfs2(int i, int j) {
		island.clear();
		island.add(new Loc(i, j, 0));
		v = new boolean[N][N];
		v[i][j] = true;
		copy = new int[N][N];
		
		while (!island.isEmpty()) {
			Loc tmp = island.poll();
			copy[tmp.x][tmp.y] = tmp.depth;
			
			for (int d = 0; d < 4; d++) {
				int nr = tmp.x + dr[d];
				int nc = tmp.y + dc[d];
				
				if(check(nr, nc) && !v[nr][nc] && map[nr][nc] == map[tmp.x][tmp.y]) {
					v[nr][nc] = true;
					island.add(new Loc(nr, nc));
				}
			}
		}
		for (int k = 0; k < v.length; k++) {
			System.out.println(Arrays.toString(v[i]));
		}

	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static void bfs(int i, int j, int cnt) {
		island.add(new Loc(i, j));

		while (!island.isEmpty()) {
			Loc tmp = island.poll();
			map[tmp.x][tmp.y] = cnt;

			for (int d = 0; d < 4; d++) {
				int nr = tmp.x + dr[d];
				int nc = tmp.y + dc[d];
				// 경계선 안에 있고 값이 같다면
				if (check(nr, nc) && map[nr][nc] == 1) {
					island.add(new Loc(nr, nc));
				}

			}
		}
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
