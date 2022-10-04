
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Loc{
		int x, y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int N, M;
	static int[][] tomato;
	static Loc loc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) {
					queue.add(new Loc(i,j));
				}
			}
		}
//		System.out.println(Arrays.toString(tomato[3]));
		bfs();
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) result = -1;
			}
		}
		
		if(result == -1) {
			System.out.println(result);
		}else System.out.println(max-1);
		
	}	
	static int cnt, max = 1;
	static Queue<Loc> queue = new LinkedList<>();
	static int[][] v = new int[N][M];
	
	private static void bfs() {
		
		while(!queue.isEmpty()) {
//			print();
			Loc tmp = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = tmp.x + dr[d];
				int nc = tmp.y + dc[d];
				if(!check(nr, nc) && tomato[nr][nc] == 0) {
					tomato[nr][nc] = tomato[tmp.x][tmp.y] +1;
					queue.add(new Loc(nr, nc));
					max = tomato[nr][nc];
				}
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= M;
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(tomato[i][j]);
			}
			System.out.println();
		}
	}
}
