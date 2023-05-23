package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class Sw1868_파핑파핑지뢰찾기 {
	static int N, result;
	static char[][] arr;
	static class Loc{
		int x, y;

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static ArrayList<Loc> list;
	static boolean[][] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			arr = new char[N][N];
			v = new boolean[N][N];
			list = new ArrayList<>();
			result = 0;
			for (int i = 0; i < arr.length; i++) {
				String s = sc.next();
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j] == '*') {
						v[i][j] = true;
					}
				}
			}
			
			bfs();
			System.out.println(list);
			bbfs();
//			print();
			System.out.println(result);
			falseCnt();
//			print();
			System.out.println(result + list.size());
		}
	}

	private static void bbfs() {
		
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			v[x][y] = true;
			for (int d = 0; d < 8; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				if(check(nr, nc) && arr[nr][nc] == '0' && !v[nr][nc]) result--;

				if(check(nr, nc) && arr[nr][nc] != '*') {
					if(!v[nr][nc]) {
						
						v[nr][nc] = true;
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void falseCnt() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(!v[i][j]) result++;
			}
		}
	}

	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	private static void bfs() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				
				boolean zeroCnt = true; // 0인지 아닌지 체크하는 변수
				for (int d = 0; d < 8; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(check(nr, nc) && arr[nr][nc] == '*') {
						zeroCnt = false;
					}
				}
				if(zeroCnt && !v[i][j]) {
					list.add(new Loc(i, j));
					arr[i][j] = '0';// 나중에 0을 만나면 하나 빼줄껍니다.
					
				}
			}
		}
			
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}