package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Boj9466_텀프로젝트 {
	static int[] arr;
	static boolean[] v, done;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 0; tc < TC; tc++) {
			int T = sc.nextInt();
			
			arr = new int[T+1];
			v = new boolean[T+1];
			done = new boolean[T+1];
			cnt = 0;
			for (int i = 1; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			for (int i = 1; i <= T; i++) {
				
				if(!done[i]) dfs(i);
				System.out.println(Arrays.toString(v));
				System.out.println(Arrays.toString(done));
			}
			
			System.out.println(T-cnt);
		}
	}

	private static void dfs(int n) {
		// 이미 방문했을 때
		if(v[n]) {
			done[n] = true;
			cnt++;
		}else {
			v[n] = true;
		}
		
		if(!done[arr[n]]) {
			dfs(arr[n]);
		}
		
		v[n] = false;
		done[n] = true;
	}

}
