 

import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int q = sc.nextInt();
		int[] arrP = new int[q];

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < q; i++) {
			arrP[i] = sc.nextInt();
		}
		for (int i = 0; i < q; i++) {
			if (arrP[i] == 1)
				rotation1();
			else if (arrP[i] == 2)
				rotation2();
			else if (arrP[i] == 3)
				rotation3();
			else if (arrP[i] == 4)
				rotation4();
			else if (arrP[i] == 5)
				rotation5();
			else if (arrP[i] == 6)
				rotation6();

		}

		print();

	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotation1() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[n - 1 - i][j];
				arr[n - 1 - i][j] = tmp;
			}
		}
	}

	private static void rotation2() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][m - j - 1];
				arr[i][m - j - 1] = tmp;
			}
		}
	}

	private static void rotation3() {
		int[][] sel = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = n - 1, k = 0; j >= 0; j--, k++) {
				sel[i][j] = arr[k][i];
			}
		}
		
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(sel[i][j] + " ");
//			}
//			System.out.println();
//		}
		arr = sel;
		int tmp = n;
		n = m;
		m = tmp;

	}

	private static void rotation4() {
		int[][] sel = new int[m][n];
		for (int i = m - 1, k = 0; i >= 0; i--, k++) {
			for (int j = 0; j < n; j++) {
				sel[i][j] = arr[j][k];
			}
		}
		arr = sel;
		int tmp = n;
		n = m;
		m = tmp;

	}

	private static void rotation5() {
		int[][] sel = new int[n][m];
		int[] dr = { 0, n / 2, n / 2, 0 };
		int[] dc = { m / 2, m / 2, 0, 0 };
		for (int d = 0; d < 4; d++) {
			int a = dr[(d+3) % 4];
			int b = dc[(d+3) % 4];
			for (int i = dr[d], k = a; i < (n/2 + dr[d]); i++, k++) {
				for (int j = dc[d], l = b; j < (m/2 + dc[d]); j++, l++) {
					sel[i][j] = arr[k][l];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sel[i][j];
			}
		}

	}

	private static void rotation6() {
		int[][] sel = new int[n][m];
		int[] dr = {n / 2, n / 2, 0, 0 };
		int[] dc = {0, m / 2, m / 2, 0 };
		for (int d = 0; d < 4; d++) {
			int a = dr[(d+3) % 4];
			int b = dc[(d+3) % 4];
			for (int i = dr[d], k = a; i < (n/2 + dr[d]); i++, k++) {
				for (int j = dc[d], l = b; j < (m/2 + dc[d]); j++, l++) {
					sel[i][j] = arr[k][l];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sel[i][j];
			}
		}
	}

}