package 브루트포스;

import java.util.Scanner;

public class Boj1977_완전제곱수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int start = -1;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
//				System.out.print(j + " ");
				if(j * j == i) {
					if(start == -1) {
						start = i;
					}
					sum += i;
//					System.out.println(i + " " + j);
				}
			}
//			System.out.println(i);
		}
		if(start != -1) System.out.println(sum);
		System.out.println(start);
	}

}
