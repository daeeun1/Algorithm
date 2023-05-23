package 시뮬레이션;

import java.util.Scanner;

public class Sw1949_등산로조성2 {
	static int N, K, maxLen, top;
	static int arr[][];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr= new int[N][N];
			maxLen = 0;
			top = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					top = Math.max(top, arr[i][j]);
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					
					for (int k = 1; k <= K; k++) {
						
						dfs(i, j, 1, false, k);
					}
				}
			}
			System.out.println("#" + tc + " " +maxLen);
		}
	}

	private static void dfs(int i, int j, int cnt, boolean isOk, int k) {
		maxLen = Math.max(maxLen, cnt);
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(check(nr, nc) && arr[i][j] < arr[nr][nc]) {
//				System.out.println("r : " + i + " c : " + j);
//				System.out.println("nr : " + nr + " nc : " + nc);
				// 깍고
				if(!isOk) {
					arr[nr][nc] -= k;
					dfs(i, j, cnt, true,k);
					arr[nr][nc] += k;
				}
				// 안깍고
				dfs(nr, nc, cnt+1, isOk,k);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
