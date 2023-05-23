package dfs;

import java.util.Scanner;

public class Sw1952_수영장 {
	static int day, oneMonth, threeMonth, year; 
	static int[] month;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			day = sc.nextInt();
			oneMonth = sc.nextInt();
			threeMonth = sc.nextInt();
			year = sc.nextInt();
			month = new int[12];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt();
			}
			
			dfs(0, 0, "");
			System.out.println("#" + tc + " " + min);
		}
			
	}

	static int min;
	private static void dfs(int idx, int sum, String a) {
		if(idx >= 12) {
//			System.out.println(a);
			min = Math.min(min, sum);
			return;
		}
		
		if(month[idx] != 0) {
			// 하루
			dfs(idx+1, sum + (month[idx] * day), a + (month[idx] * day) + " ");
			
			// 한달
			dfs(idx+1, sum + oneMonth, a + oneMonth + " ");

			// 세달
			 dfs(idx+3, sum + threeMonth, a + threeMonth + " ");
			
			// 일년
			if(idx == 0) dfs(12, year, a + year + " ");
		}else {
			dfs(idx+1, sum, a);
		}
		
	}

}
