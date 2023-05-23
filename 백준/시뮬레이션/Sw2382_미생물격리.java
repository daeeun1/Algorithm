package 시뮬레이션;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sw2382_미생물격리 {
	static int N, M, K; 
	static class Bug{
		int r, c, num, dist;

		public Bug(int r, int c, int num, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Bug [r=" + r + ", c=" + c + ", num=" + num + ", dist=" + dist + "]";
		}
		
	}
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	static ArrayList<Bug> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			list = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				list.add(new Bug(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			
			
			
			for (int i = 0; i < M; i++) {
				work();
			}
			
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).num;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}


	private static void work() {
		int[][] tmpMap = new int[N][N];
		ArrayList<Bug> sumList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			int d = list.get(i).dist;
			int nr = list.get(i).r += dr[d];
			int nc = list.get(i).c += dc[d];
			int size = list.get(i).num;
			
			list.get(i).r = nr;
			list.get(i).c = nc;

//			System.out.println(nr + " " + nc);
			// 경계선이면 방향 바꿈
			if(lineCheck(nr, nc)) {
				
				if(d == 1) list.get(i).dist = 2;
				else if(d == 2) list.get(i).dist = 1;
				else if(d == 3) list.get(i).dist = 4;
				else if(d == 4) list.get(i).dist = 3;
				
				size = list.get(i).num /= 2;
				
				if(size == 0) {
					list.remove(i);
					i--; 
				}
			}
			if(size > 0) {
			if(tmpMap[nr][nc] > 0) {
				
				// 비교하기
				for (int j = 0; j < sumList.size(); j++) {
					int sr = sumList.get(j).r;
					int sc = sumList.get(j).c;
					int sSize = sumList.get(j).num;
					
					if(sr == nr && sc == nc) {
//						System.out.println(tmpMap[nr][nc]);
//						System.out.println(sSize + " " + size);
						tmpMap[nr][nc] += size; 

						// 사이즈 큰거 비교하기 
						if(sSize < size) {
							
							sumList.get(j).num = size; 
							sumList.get(j).dist = d;
						}
					}
					
 				}
				
				
			}else {
				tmpMap[nr][nc] = size; 
				sumList.add(list.get(i));
			}}
			
		}
		
				
		for (int k = 0; k < sumList.size(); k++) {
						
			sumList.get(k).num = tmpMap[sumList.get(k).r][sumList.get(k).c];
		}
		
		list = new ArrayList<>();
		for (Bug bug : sumList) {
			list.add(bug);
		}
		
		for (int j = 0; j < tmpMap.length; j++) {
			System.out.println(Arrays.toString(tmpMap[j]));
		}
		for (int j = 0; j < sumList.size(); j++) {
			System.out.println(list.get(j));
		}
		System.out.println();
	}

	private static boolean lineCheck(int nr, int nc) {
		return nr == 0 || nc == 0 || nr == N-1 || nc == N-1;
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}








