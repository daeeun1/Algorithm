 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int K;
	static class Loc {
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
	static ArrayList<Loc> arr ;
	static Loc home ;
	static Loc job ;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int TC = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= TC; tc++) {
			K = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			arr = new ArrayList<>();
			min = Integer.MAX_VALUE;
			job = (new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			home = (new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
			for (int i = 0; i < K; i++) {
				
				arr.add(new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
//			System.out.println(arr.toString());
//			System.out.println(home.toString());
			
			int[] arr = new int[K];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			
//			System.out.println(home.get(0).x + " : " + home.get(0).y);
			prew(new boolean[K], 0, new int[K], arr);
			System.out.println("#" + tc + " " + min);
		}
	}

	static int min = Integer.MAX_VALUE;
	private static void prew(boolean[] v, int idx, int[] sel, int[] arr1) {
		if(sel.length == idx) {
//			System.out.println(Arrays.toString(sel));
//			System.out.println(dist(sel));
			int d = Math.abs(job.x - arr.get(sel[0]).x) + Math.abs(job.y - arr.get(sel[0]).y);
			for (int i =1; i < sel.length ; i++) {
				d += Math.abs(arr.get(sel[i-1]).x - arr.get(sel[i]).x) + Math.abs(arr.get(sel[i-1]).y - arr.get(sel[i]).y);
			}
			d += Math.abs(home.x - arr.get(sel[sel.length-1]).x) + Math.abs(home.y - arr.get(sel[sel.length-1]).y); 
			min = Math.min(d, min);
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = arr1[i];
				prew(v, idx+1, sel, arr1);
				v[i] = false;
			}
		}
	}

}
