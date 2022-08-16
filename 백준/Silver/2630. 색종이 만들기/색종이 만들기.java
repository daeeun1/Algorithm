import java.util.Scanner;

public class Main {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		space( 0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	static int white, blue;

	private static void space(int x, int y, int n) {

		if (check(x, y, n)) {
			if(arr[x][y] == 0) white++;
			else blue ++;
			return;
		}
		int size = n/2;
		
		space(x, y, size);
		space( x, y + size, size);
		space( x + size, y,size);
		space( x + size, y + size, size);

	}

	private static boolean check(int x, int y, int size) {
		int tmp = arr[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(arr[i][j] != tmp) return false;
			}
 		}
		return true;
	}

}
