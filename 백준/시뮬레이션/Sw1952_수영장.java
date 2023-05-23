package 시뮬레이션;

import java.util.Scanner;

public class Sw1952_수영장 {
	static int day, oneMonth, threeMonth, year, min;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= tc; tc++) {
			day = sc.nextInt();
			oneMonth = sc.nextInt();
			threeMonth = sc.nextInt();
			year = sc.nextInt();
			arr = new int[12];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(0, 0);
			System.out.println(min);
		}
	}

	private static void dfs(int idx, int sum) {
		if(idx == arr.length) {
			min = Math.min(min, sum);
			
			System.out.println(sum);
			return;
		}
		
		if(arr[idx] != 0) {
			// 하루
			dfs(idx+1, sum + arr[idx] * day);
			
			// 한달
			dfs(idx+1, sum + arr[idx]*oneMonth);
			
			// 세달
			if(idx < arr.length-2) {
				dfs(idx+3, sum + arr[idx] * threeMonth);
			}
			
			// 일년
			if(idx == 0) dfs(idx + 12, sum + year);
		}else if(idx < 12) {
			dfs(idx+1, sum);
		}
		
	}

}
