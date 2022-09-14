import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
	static int N, M;
	static int[][] map;
	static ArrayList<Loc> home;
	static ArrayList<Loc> chi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		home = new ArrayList<>();
		chi  = new ArrayList<>();
//		System.out.println(home);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) home.add(new Loc(i, j));
				else if(map[i][j] == 2) chi.add(new Loc(i, j));
			}
		}
//		System.out.println(home.toString());
		int[] arr = new int[chi.size()];
		for (int i = 0; i < chi.size(); i++) {
			arr[i] = i;
		}
		comb(0, new int[M], arr, 0);
		System.out.println(result);
	}
	
	static int result = Integer.MAX_VALUE;
	private static void comb(int idx, int[] sel, int[] arr, int k) {
		if(sel.length == k) {
//			System.out.println(Arrays.toString(sel));
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					dist =  Math.min(dist, calc(home.get(i),chi.get(sel[j])));
				}
				sum += dist;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			comb(i+1, sel, arr, k+1);
		}
	}
	private static int calc(Loc loc1, Loc loc2) {
		// TODO Auto-generated method stub
		return Math.abs(loc1.x - loc2.x)+Math.abs(loc1.y-loc2.y);
	}

}
