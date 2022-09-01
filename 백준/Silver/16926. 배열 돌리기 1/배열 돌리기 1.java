import java.util.Scanner;

public class Main {
	static int N, M, R;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			turn();
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void turn() {
		
		for (int k = 0; k < Math.min(N, M)/2; k++) {
			int i = k, j = k, d = 0;
			int nr = 0;
			int nc = 0;
			int tmp = arr[k][k];
			while(d < 4) {
				nr = i + dr[d];
				nc = j + dc[d];
				if(check(nr, nc, k)) {
					arr[i][j] = arr[nr][nc];
					i = nr;
					j = nc;
//					System.out.println(nr + " " + nc);
				}else {
					d++;
				} 
			}
			arr[k+1][k] = tmp;
		}
	}

	private static boolean check(int nr, int nc, int k) {
		return nr >= k && nr < N - k && nc >= k && nc < M - k;
	}

}
