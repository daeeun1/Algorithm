package 백트랙킹;

import java.util.Scanner;

public class Boj14888_연산자끼워넣기 {
	static int[] four, arr;
	static int N, max, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		arr = new int[N];
		four = new int[4]; // {'+', '-', '*', '/'};
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < four.length; i++) {
			four[i] = sc.nextInt();
		}
		
		dfs(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(four[i] > 0) {
				four[i]--;
				
				if(i == 0) dfs(num + arr[idx], idx+1);
				else if(i == 1) dfs(num - arr[idx], idx+1);
				else if(i == 2) dfs(num * arr[idx], idx+1);
				else if(i == 3) dfs(num / arr[idx], idx+1);
				
				four[i]++;
			}
		}
		
	}

}
