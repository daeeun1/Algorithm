package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class Sw2383_점심식사시간 {
	static int N;
	static class Loc{
		int x, y, k;

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Loc(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
	}
	static ArrayList<Loc> list, man;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			list = new ArrayList<>();
			man = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) man.add(new Loc(i, j));
					else if(arr[i][j] != 0) list.add(new Loc(i, j));
				}
			}
			
			for (Loc loc : man) {
				for (Loc stair : list) {
					
				}
			}
		}
		
	}

}
