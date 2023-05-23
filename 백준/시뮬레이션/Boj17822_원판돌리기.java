package 시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class Boj17822_원판돌리기 {
	static int N, T, M, X, D, K, sum;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] arr;
	static int[][] copy;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		arr = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		print(arr);
		for (int i = 0; i < T; i++) {
			X = sc.nextInt();
			D = sc.nextInt();
			K = sc.nextInt();
			
			int tmpSum = 0;
			circle(tmpSum);
			System.out.println();
//			print(arr);
		}
		System.out.println(sum);
	}

	private static void circle(int tmpSum) {
		sum = 0;
		// 0, M+1에도 마지막 값, 첫 값을 넣어주면 쉬움
		for (int i = 0; i < N; i++) {
			arr[i][0] = arr[i][M];
			arr[i][M+1] = arr[i][1];
		}
		
		// 시계방향
		// x = 2, d = 0, k =1 2의 배수, 시계방향, 한칸
		if(D == 0) {
			
			int x = X;
			while(x <= N) {
				for (int i = 0; i < K; i++) {
					for (int y = M+1; y > 0; y--) {
						arr[x][y] = arr[x][y-1];
					}
					arr[x][1] = arr[x][M+1];
					
				}
				x *= X;
			}
		}
		
		// 반시계방향
		else {
			int x = X;
			while(x <= N) {
				for (int i = 0; i < K; i++) {
					for (int y = 0; y < M; y++) {
						arr[x][y] = arr[x][y+1];
					}
					arr[x][M] = arr[x][0];
					
				}
				x *= X;
			}
		}
		
		// 인접하면서 수가 같은 것을 모두 지우기
		arrDelete();
		
//		print(copy);
		
		double avg = sum/cnt;
		System.out.println(avg);
		
		if(tmpSum == sum) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < M+1; j++) {
					
				}
			}
		}
	}

	static int cnt = 0;
	private static void arrDelete() {
		copy = new int[N+2][M+2];
		cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				boolean flag = false;
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(check(nr, nc) && arr[i][j] == arr[nr][nc]) {
						flag = true;
					}
					
				}
				
				if(flag) copy[i][j] = 0;
				else {
					copy[i][j] = arr[i][j];
					sum += copy[i][j];
					cnt ++;
				}
			}
		}
		arr = copy;
		
	}

	private static boolean check(int nr, int nc) {
		return nr > 0 && nr <= N && nc > 0 && nc <= M ;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
			
	}

}
