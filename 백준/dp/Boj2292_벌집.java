package dp;

import java.util.Scanner;

public class Boj2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[10000000];

		int N = sc.nextInt();

		dp[1] = 1;
		if (N == 1)
			System.out.println(N);
		else {
			int i = 2;
			while (true) {
				dp[i] = dp[i - 1] + 6 * (i - 1);
//				System.out.println(dp[i]);
				if (dp[i] >= N)
					break;
				i++;
			}
			System.out.println(i);
		}
	}

}
