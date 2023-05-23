package 시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K, result;
	static boolean isOk;
	static int[][] mak, tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			mak = new int[D][W];
			tmp = new int[W][D];
			min = Integer.MAX_VALUE;
			isOk = true; // 이게 false로 바뀌면 그냥 고자리에서 끝납니다.
			result = 0;
			
			for (int i = 0; i < mak.length; i++) {
				for (int j = 0; j < mak[i].length; j++) {
					mak[i][j] = sc.nextInt();
					tmp[j][i] = mak[i][j];
				}
			}
			
			// 맨 처음에 검사하기 위해서.
			
			check();
//			System.out.println(isOk);
			
			
			while(!isOk) {
				result++;
				int v = 0;

				comb(new int[D], new int[result], 0, 0);
				if(v > 0) break;
				
			}
			if(min == Integer.MAX_VALUE) min = 0;
			System.out.println("#" + tc + " " + min);
			
		}
	}

	static int min;
	private static void prew(int[] sel, int[] arr, int k) {
		if(isOk) return;
		
		int[][] tmpMak = new int[D][W];
		int[][] tmptmpMak = new int[W][D];
		for (int i = 0; i < tmpMak.length; i++) {
			for (int j = 0; j < tmpMak[i].length; j++) {
				tmpMak[i][j] = mak[i][j];
				tmptmpMak[j][i] = mak[i][j];
			}
		}
		
		if(sel.length == k) {
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < tmpMak[i].length; j++) {
					tmptmpMak[j][arr[i]] = tmpMak[arr[i]][j] = sel[i];
				}
			}
//			for (int i = 0; i < tmpMak.length; i++) {
//				System.out.println(Arrays.toString(tmpMak[i]));
//			}
//			System.out.println();
			// 이제 검사
			isOk = true;
			for (int i = 0; i < tmptmpMak.length; i++) {
				int cnt = 1;
				int maxCnt = 0;
				for (int j = 1; j < tmptmpMak[i].length; j++) {
					if(tmptmpMak[i][j-1] == tmptmpMak[i][j]) {
						cnt++;
					}
					else cnt = 1;
					
					maxCnt = Math.max(maxCnt, cnt);
				}
//				System.out.println(maxCnt);
				if(maxCnt < K) {
					isOk = false;
					return;
				}
			}
//			System.out.println();
			if(isOk) {
				min = Math.min(min, arr.length);
			}
			return;
		}
		
		for (int i = 0; i < AB.length; i++) {
				sel[k] = AB[i];
				prew(sel, arr, k+1);
		}
	}

	private static void comb(int[] arr, int[] sel, int idx, int k) {
		if(isOk) return;
		
		if(k==sel.length) {
//			for (int i = 0; i < sel.length; i++) {
//				System.out.print(sel[i] + " ");
//			}
//			System.out.println();
			prew(new int[result], sel, 0);
			
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k]=i;
			comb(arr, sel, i+1, k+1);
		}

		
		
	}

	static int[] AB = {0, 1};
	private static void check() {
		
		for (int i = 0; i < tmp.length; i++) {
			int cnt = 1;
			int maxCnt = 0;
			for (int j = 1; j < tmp[i].length; j++) {
				if(tmp[i][j-1] == tmp[i][j]) {
					cnt++;
				}
				else cnt = 1;
				
				maxCnt = Math.max(maxCnt, cnt);
			}
//			System.out.println(maxCnt);
			if(maxCnt < K) isOk = false;
		}		
	}

	
}
