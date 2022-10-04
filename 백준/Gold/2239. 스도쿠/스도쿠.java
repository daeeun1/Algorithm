 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static ArrayList<Loc> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		list = new ArrayList<>();
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';
				if(arr[i][j] == 0) list.add(new Loc(i, j));
			}
		}
//		System.out.println(Arrays.toString(arr[1]));
		sudoku(0);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	static boolean end;
	private static void sudoku(int idx) {
		if(idx == list.size()) {
			end = true;
			return;
		}
		
		Loc loc = list.get(idx);
		for (int i = 1; i <= 9; i++) {
			arr[loc.x][loc.y] = i;
			
			if(row(loc.x, loc.y) && col(loc.x, loc.y) && three(loc.x, loc.y))
				sudoku(idx+1);
			if(end) return;
			
			
			arr[loc.x][loc.y] = 0;
		}
		
		
	}



	private static boolean three(int r, int c) {
		int x, y = 0;
		if(r < 3) x = 0;
		else if(r < 6) x = 1;
		else x = 2;
		
		if(c < 3) y = 0;
		else if(c < 6) y = 1;
		else y = 2;
		
		for (int i = x*3; i < x*3+3; i++) {
			for (int j = y*3; j < y*3+3; j++) {
				if(i != r || j != c) {
					if(arr[i][j] == arr[r][c]) return false;
				}
			}
		}
		return true;
	}



	private static boolean col(int x, int y) {
		for (int i = 0; i < 9; i++) {
			if(i != x) {
				if(arr[i][y] == arr[x][y]) return false; 
			}
		}
		
		return true;
	}



	private static boolean row(int x, int y) {
		for (int i = 0; i < 9; i++) {
			if(y != i) {
				if(arr[x][i] == arr[x][y]) return false; 
			}
		}
		
		return true;
	}	

}
