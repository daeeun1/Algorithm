package 시뮬레이션;

import java.util.Scanner;

public class Sw1949_등산로조성 {
	static int N, K, maxLen, top;
	static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr= new int[N][N];
			top = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					top = Math.max(top, arr[i][j]);
				}
			}
			
			maxLen = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					int len = 1;
					dfs(i, j, len, 0);
					System.out.println(maxLen);
				}
			}
		}
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(int i, int j, int len, int k) {
		maxLen = Math.max(maxLen, len);
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			// 0일때
			if(check(nr, nc) && arr[i][j] < arr[nr][nc]) {
				dfs(nr, nc, len+1, k);
			}
			if(k == 0 && check(nr, nc) && arr[i][j] == arr[nr][nc]) { 
				arr[i][j] -= K;
				dfs(nr, nc, len+1, k+1);
				arr[i][j] += K;
			}
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
