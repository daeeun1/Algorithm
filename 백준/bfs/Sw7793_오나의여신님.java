package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sw7793_오나의여신님 {
	static int N, M;
	static char[][] map;
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
	    
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        map = new char[N][];
	        
	        // 초기화
	        min = Integer.MAX_VALUE;
	        queueH.clear();
	        queueD.clear();
	        
	        for (int i = 0; i < N; i++) {
	            map[i] = br.readLine().toCharArray();
	            for (int j = 0; j < M; j++) {
	                char ch = map[i][j];
	                if( ch == 'S' ) queueH.add(new Loc(i, j)); // 수연
	                else if( ch == '*' ) queueD.add(new Loc(i, j)); // 악마 (복수) // 가령 3개
	            }
	        }
			
			bfs(tc);
			if(min != Integer.MAX_VALUE) System.out.println("#" + tc + " " + min);
			else System.out.println("#" + tc + " GAME OVER");
		}
	}
	static int min;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Queue<Loc> queueH = new LinkedList<>();
	static Queue<Loc> queueD = new LinkedList<>();
	static int deep ;
	private static void bfs(int tc) {
		while(true) {
			// 악마가 퍼진다
			for (int i = 0; i < queueD.size(); i++) {
				Loc tmp = queueD.poll();
				for (int d = 0; d < 4; d++) {
					int nr = tmp.x + dr[d];
					int nc = tmp.y + dc[d];
					
					if(check(nr, nc) && map[nr][nc] != 'D' && map[nr][nc] != 'X' && map[nr][nc] != '*') {
						map[nr][nc] = '*';
						queueD.add(new Loc(nr, nc));
					}
				}
				
			}
			for (int i = 0; i < queueH.size(); i++) {
				Loc tmp = queueH.poll();
				for (int d = 0; d < 4; d++) {
					int nr = tmp.x + dr[d];
					int nc = tmp.y + dc[d];
					
					if(check(nr, nc) && map[nr][nc] != '*' && map[nr][nc] != 'X' && map[nr][nc] != 'S') {
						if(map[nr][nc] == 'D') {
							min = ++deep;
							return;
						}
						map[nr][nc] = 'S';
						queueH.add(new Loc(nr, nc));
					}
				}
				
			}
			if(queueH.size() == 0) {
				break;
			}
			deep++;
			
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
