import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m, r, c, s, q;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] tmp;
	static int min = 987654321;
	static int[][] arr;
	static int[][] arrTmp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		arrTmp= new int[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				arrTmp[i][j] = arr[i][j];
			}
		}

		int[][] two = new int[q][3];
		for (int j = 0; j < q; j++) {
			two[j][0] = sc.nextInt();
			two[j][1] = sc.nextInt();
			two[j][2] = sc.nextInt();
		}
		int[] sel = new int[q];
		for (int i = 0; i < q; i++) {
			sel[i] = i;
		}

		tmp = new int[sel.length];
		boolean[] v = new boolean[sel.length];
		recur(sel, v, 0, two);

		System.out.println(min);

	}

	private static void recur(int[] sel, boolean[] v, int idx, int[][] two) {
		if (idx == sel.length) {
			
			for (int is : tmp) {
				r = two[is][0];
				c = two[is][1];
				s = two[is][2];
				rotation(arr);
			}

			for (int t = 0; t <n; t++) {
				int cnt = 0;
				for (int j = 0; j < m; j++) {
					cnt += arr[t][j];
					arr[t][j] = arrTmp[t][j];
				}
				min = Math.min(min, cnt);
			}
			
			return;
		}

		for (int i = 0; i < tmp.length; i++) {
			if (v[i])
				continue;
			v[i] = true;
			tmp[idx] = sel[i];
			recur(sel, v, idx + 1, two);
			v[i] = false;
		}
	}

	private static void rotation(int[][] arr) {
		for (int i = 0; i < s; i++) {
			int d = 0;
			int x = r - s - 1 + i, y = c - s + i - 1; // 시작 값
			int tmp = arr[x][y];
			while (d < 4) {
				// 안쪽까지 검사하려고 i를 주었습니다!
				int nr = x + dr[d];
				int nc = y + dc[d];
				// 범위에 있고
				if (nr >= r - s - 1 + i && nr < r + s - i && nc >= c - s - 1 + i && nc < c + s - i) {
					arr[x][y] = arr[nr][nc];
					x = nr;
					y = nc;
				} // 범위를 벗어나거나 값이 있다면 d++;
				else {
					d++;
				}

			}
			arr[r - s + i - 1][c - s + i] = tmp;
		}

	}

}