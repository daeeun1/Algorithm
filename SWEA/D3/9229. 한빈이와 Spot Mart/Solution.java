
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
	static int[] temp;
	static int max, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			// 과자 봉지 무게 배열
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			// 과자 두봉지!
			temp = new int[2];
			result = 0;
			comb(a, 0, 0, m);
			if(result == 0) result = -1;
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void comb(int[] a, int idx, int k, int m) {
		if (temp.length == k) {
			max = 0;
			for (int i  : temp) {
				max += i;
			}
			if (max <= m) result = Math.max(max, result);
			return;
		}
		for (int i = idx; i < a.length; i++) {
			temp[k] = a[i];
			comb(a, i+1,k+1, m);
		}
	}

}
