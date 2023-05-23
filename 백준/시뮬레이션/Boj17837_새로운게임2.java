package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj17837_새로운게임2 {
	static int N, K;
	static class Loc{
		int x, y, dist;

		public Loc(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
	}
	static int[][] arr;
	static ArrayList<Loc>[] adj;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N+1][N+1];
		adj = new ArrayList[N];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			adj[i] = new ArrayList<Loc>();
			adj[i].add(new Loc(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		int cnt = 0;
		L: while(cnt < 1000) {
			
			for (int i = 0; i < N; i++) {
				if(adj[i].size() >= 4) break L;
				
				for (int j = 0; j < adj[i].size(); j++) {
					int nr = adj[i].get(j).x + dr[adj[i].get(j).dist];
					int nc = adj[i].get(j).y + dc[adj[i].get(j).dist];
					
					// 빼니까 삭제해줄꺼고 아래에서 추가해줄꺼임
					adj[i].remove(j);
					j--;
					
					// 경계선 체크, 흰색일 경우에 
					if(check(nr, nc) && arr[nr][nc] == 0) {
						
						// 어떻게 만나느냐
					}
					
				}
			}
			
			cnt++;
		}
		System.out.println(cnt >= 1000 ? -1:cnt);
	}

	private static boolean check(int nr, int nc) {
		return nr >= 1 && nr <=N  && nc >= 1 && nc < N;
	}

}
