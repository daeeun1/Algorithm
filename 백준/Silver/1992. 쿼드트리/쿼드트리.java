import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		tree = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < n; j++) {
				tree[i][j] = s.charAt(j) - '0';
			}
//			System.out.println(Arrays.toString(tree[i]));
		}
		
		space(0, 0, n);
	}
	private static void space(int x, int y, int n) {
		if(check(x, y, n)) {
			System.out.print(tree[x][y]);
			return;
		}
		
		System.out.print('(');
		space(x, y, n/2);
		space(x, y + n/2, n/2);
		space(x + n/2, y, n/2);
		space(x+n/2, y+n/2, n/2);
		System.out.print(')');
		
		
	}
	private static boolean check(int x, int y, int size) {
		int tmp = tree[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(tree[i][j] != tmp) return false;
			}
 		}
		return true;
	}
}
