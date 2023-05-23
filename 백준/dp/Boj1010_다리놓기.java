package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1010_다리놓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] dp = new int[M+1][M+1];
			for (int i = 1; i <= M; i++) {
				for (int j = 0; j <= M; j++) {
//					System.out.println(j);

					// 0이냐 마지막이면 
					if(j == 0 || j == i ) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
					
				}
			}
			System.out.println(dp[M][N]);
		}
	}

}
