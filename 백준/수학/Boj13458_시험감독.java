package 수학;

import java.util.Scanner;

public class Boj13458_시험감독 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		long cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] -= B;
			cnt ++;
			if(arr[i] > 0) {
				cnt += arr[i] / C;
				if(arr[i] % C != 0) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
