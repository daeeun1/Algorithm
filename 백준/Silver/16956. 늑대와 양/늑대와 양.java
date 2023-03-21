import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
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
	static Queue<Loc> queue;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		queue = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'W') queue.add(new Loc(i, j));
			}
		}
		
//		System.out.println(queue.toString());
		boolean result = bfs();
		if(result) {
			System.out.println(1);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else System.out.println(0);
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static boolean bfs() {
		while(!queue.isEmpty()) {
			Loc tmp = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + tmp.x;
				int nc = dc[d] + tmp.y;
				
				if(check(nr, nc)) {
					if(map[nr][nc] == '.') {
						map[nr][nc] = 'D';
					}
					else if(map[nr][nc] == 'S') return false;
				}
			}
		}
		return true;
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
