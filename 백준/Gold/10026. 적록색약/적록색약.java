 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

    static class Loc{
        int x, y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Loc loc;
    static boolean[][] v;
    static int N;
    static char[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int k = 0; k < 2; k++) {
        	v = new boolean[N][N];
        	cnt = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if(!v[i][j]) bfs(i, j);
        		}
        	}
        	
        	for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 'G') map[i][j] = 'R';
                }
            }
        	System.out.print(cnt + " ");
			
		}
    }
    
    static int cnt;
    static Queue<Loc> queue = new LinkedList<>();
    private static void bfs(int i, int j) {
        queue.add(new Loc(i, j));
        v[i][j] = true;

        while(!queue.isEmpty()) {
        	Loc tmp = queue.poll();
        	for (int d = 0; d < 4; d++) {
        		int nr = tmp.x + dr[d];
        		int nc = tmp.y + dc[d];
				if(!check(nr, nc) && map[tmp.x][tmp.y] == map[nr][nc] && !v[nr][nc]) {
					v[nr][nc] = true;
					queue.add(new Loc(nr, nc));
				}
			}
        }
        cnt ++;

    }
    
    private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}

}