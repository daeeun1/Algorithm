package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class Sw1949_등산로조성4 {
	static int N, K, max, top;
	static int[][] arr;
	static class Loc{
		int x, y, len;

		public Loc(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.len = d;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + ", d=" + len + "]";
		}
		
	}
	static ArrayList<Loc> topList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];
			top = 0;
			topList = new ArrayList<>();
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if(top < arr[i][j]) {
						top = arr[i][j];
						topList = new ArrayList<>();
						topList.add(new Loc(i, j, 1));
					}else if(top == arr[i][j]) {
						topList.add(new Loc(i, j, 1));
					}
				}
			}
			
//			System.out.println(topList);
			for (int i = 0; i < topList.size(); i++) {
				int a = K;
				for (int k = 1; k <= a; k++) {
					K = k;
					v = new boolean[N][N];
					
					v[topList.get(i).x][topList.get(i).y] = true;
					dfs(topList.get(i).x, topList.get(i).y, topList.get(i).len, 0, ""); 
					v[topList.get(i).x][topList.get(i).y] = false;
					
				}
				K = a;
//				System.out.println();
			}
			System.out.println("#"+ tc + " " + max);
		}
	}
	
	static boolean[][] v;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(int x, int y, int len, int k, String a) {
		max = Math.max(len, max);
//		System.out.println(a);
		
		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			if(check(nr, nc) && !v[nr][nc]) {
				
				if(arr[nr][nc] >= arr[x][y]) {
					// 먼저 자르고 시작
					if(k == 0 && arr[nr][nc]-K < arr[x][y] && arr[nr][nc] - K >= 0) {
						v[nr][nc] = true;
						arr[nr][nc] -= K;
						dfs(nr, nc, len+1, 1, a + nr + nc + " ");
						arr[nr][nc] += K;
						v[nr][nc] = false;
					}
					
				}
				
				// 1일 경우
				else {
					
					v[nr][nc] = true;
					dfs(nr, nc, len+1, k, a + nr + nc + " ");
					v[nr][nc] = false;
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
