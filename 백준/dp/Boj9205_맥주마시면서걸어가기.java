package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj9205_맥주마시면서걸어가기 {
	static int T, N;
	static ArrayList<Loc> list;
	static class Loc{
		int x, y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			dist = new int[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				list.add(new Loc(r, c));
			}
			
			for (int i = 0; i < N+2; i++) {
				for (int j = i+1; j < N+2; j++) {
					dist[i][j] = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
					
					if(dist[i][j] > 1000) {
						dist[i][j] = -1;
						dist[j][i] = -1;
					}
				}
			}
//			
//			for (int i = 0; i < dist.length; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
//			
			flo();
			
//			for (int i = 0; i < dist.length; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			
			if(dist[0][N+1] == -1)System.out.println("sad");
			else System.out.println("happy");
		}
	}

	private static void flo() {
		for (int k = 0; k < N+2; k++) {
			for (int i = 0; i < N+2; i++) {
				if(k==i) continue;
				for (int j = 0; j < N+2; j++) {
					
					if(i==j || j == k)continue;
					// 연결 못하는 곳 거르기
					if(dist[i][k] == -1 || dist[k][j] == -1) continue;
					dist[i][j] = 1;
				}
			}
		}
	}
}
