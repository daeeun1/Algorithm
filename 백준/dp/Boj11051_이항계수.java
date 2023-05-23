package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11051_이항계수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[N+1][N+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(i == N && K+1 == j) break;
				if(j > i) break;
				
				if(j == 0 || j == i) dp[i][j] = 1;
				else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}

//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dp[N][K] );
		
	}

}
