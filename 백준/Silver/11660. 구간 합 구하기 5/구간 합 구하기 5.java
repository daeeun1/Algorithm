 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		int[][] sel = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt() + arr[i][j - 1] + arr[i - 1][j] - arr[i-1][j-1];
			}
		}
//		for (int i = 0; i < sel.length; i++) {
//			for (int j = 0; j < sel[i].length; j++) {
//				System.out.print(sel[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(arr[x][y] - arr[x ][b-1] - arr[a-1][y] + arr[a-1][b-1]);
		}
	}

}
