package 시뮬레이션;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw1868_파핑파핑지뢰찾기2 {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			v = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				String s = sc.next();
				for (int j = 0; j < arr.length; j++) {
					if(s.charAt(j) == '*') arr[i][j] = arr[i][j] = -1;
				}
			}
			
			zeroFind();
			System.out.println("#" + tc + " " +cnt);
		}
	}

	private static void zeroFind() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				
				// 0인 부분은 false
				int mine = 0;
				for (int d = 0; d < 8; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(check(nr, nc) && arr[nr][nc] == -1) {
						mine++;
					}
				}
				
				if(arr[i][j] != -1)arr[i][j] = mine;
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(v[i]));
//		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				
				if(arr[i][j] > -1 && !v[i][j]) {
					cnt++;
					System.out.println(i + " " + j);
					bfs(i, j);
					
					for (int k = 0; k < arr.length; k++) {
							System.out.println(Arrays.toString(v[k]));
					}
					System.out.println();
				}
			}
		}
		
//		System.out.println();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(v[i]));
//		}
//		
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}

	private static void bfs(int r, int c) {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(r, c));
		
		while(!queue.isEmpty()) {
			Loc tmp = queue.poll();
			v[tmp.x][tmp.y] = true;
			
			if(arr[tmp.x][tmp.y] == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = tmp.x + dr[d];
					int nc = tmp.y + dc[d];
					if(check(nr, nc)) {
						v[nr][nc] = true;
						if(arr[nr][nc] == 0 && !v[nr][nc]) {
							queue.add(new Loc(nr, nc));
		//						System.out.println(nr + " " + nc);
						}
					}
				}
			}else {
				for (int d = 0; d < 8; d++) {
					int nr = tmp.x + dr[d];
					int nc = tmp.y + dc[d];
					if(check(nr, nc) && arr[nr][nc] == 0 && !v[nr][nc]) {
							queue.add(new Loc(nr, nc));
		//						System.out.println(nr + " " + nc);
						
					}
				}
			}
			
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

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
}
