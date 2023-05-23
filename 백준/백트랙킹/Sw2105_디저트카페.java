package 백트랙킹;


import java.util.Arrays;
import java.util.Scanner;

public class Sw2105_디저트카페 {
	static int N, max;
	static int[][] cafe;
	static boolean[][] v;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, 1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			cafe = new int[N][N];
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < cafe.length; i++) {
				for (int j = 0; j < cafe[i].length; j++) {
					cafe[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					v = new boolean[N][N]; // 방문배열
					startX = i; 
					startY = j;
					dfs(i, j, 0, new boolean[101], 0);// 인덱스가 방문했는지 안했는지 나타나는 불린
//					System.out.println();
				}
			}
			System.out.println("#" + tc + " " + (max > 0 ? max : -1));
		}
		
	}
	static int startX, startY;
	// 같은 거 비교하는 ten, d는 나가는 방향
	private static void dfs(int r, int c, int len, boolean[] ten, int d) {
//		System.out.println("r : " + r + " c : " + c + " len : " + len + " val : " + cafe[r][c] + " d : " + d);
		if(r == startX && c == startY && len != 0) {
			max = Math.max(max, len);
//			System.out.println("max : " + len);
			return;
		}
		
		if((d == 2) && (r < startX)) {
			return;
		}
		
		int nr = r + dr[d];
		int nc = c + dc[d];
		// 경계선 안에 있고, 같은 값이 아니고, 방문하지 않았다면
		
		
		if(check(nr, nc) && !ten[cafe[nr][nc]] && !v[nr][nc]) {
			ten[cafe[nr][nc]] = true;
			v[nr][nc] = true;
			if(d == 0) {
				// 방향 우아래
				dfs(nr, nc, len+1, ten, 0);
				
				// 방향 왼아래
				dfs(nr, nc, len+1, ten, 1);
			}
			else if(d == 1) {
				// 방향 왼아래
				dfs(nr, nc, len+1, ten, 1);
				
				// 방향 왼위
				dfs(nr, nc, len+1, ten, 3);
			}
			else if(d == 3) {
				// 방향 왼위
				dfs(nr, nc, len+1, ten, 3);
				
				// 방향 오른위
				dfs(nr, nc, len+1, ten, 2);
			}else if(d == 2) {
				for (int i = 0; i < 3; i++) {
					dfs(nr, nc, len+1, ten, 2);
					
				}
			}
			v[nr][nc] = false;
			ten[cafe[nr][nc]] = false;
		}
	}
	
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
