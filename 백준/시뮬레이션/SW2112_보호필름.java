package 시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class SW2112_보호필름 {
	static int D, W, K, result;
	static boolean isOk;
	static int[][] mak, tmp;
	
	// 부분집합 후 조합으로 짤라다가 정신나감
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			mak = new int[D][W];
			tmp = new int[W][D];
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
			System.out.println(isOk);
			
			if(isOk) System.out.println(result);
			else powerset(new int[D], new boolean[D], 0, 0, 0);
			
			// 1. powerset으로 돌리고
			// 2. 돌린 걸 각각 K만큼 있으면 true 해서 확인 시킵니다.
			
		}
	}

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

	private static void prew(int[] sel, int k, boolean[] v) {
		if(sel.length == k) {
//			isOk = true;
//			
//			// 배열 바꾸기
//			for (int i = 0; i < v.length; i++) {
//				if(!v[i]) {
//					
//				}
//			}
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = 0; i < AB.length; i++) {
				sel[k] = AB[i];
				prew(sel,  k+1, v);
		}
	}

	static int[] AB = {0, 1};
	private static void powerset(int[] arr, boolean[] sel, int idx, int k, int cnt) {
		if(sel.length == idx) {
			// 조합을 짜야합니다.
			prew(new int[cnt], 0, sel);
			
			
			return;
		}
		sel[idx] = true;
		powerset(arr, sel, idx+1, k+1, cnt+1);

		sel[idx] = false;
		powerset(arr, sel, idx+1, k, cnt);
		
	}

	private static void changeLine(int[][] line, int x) {
		for (int i = 0; i < mak.length; i++) {
			for (int j = 0; j < mak[i].length; j++) {
				line[i][j] = mak[i][j];
			}
		}
		
		
		for (int j = 0; j < W; j++) {
				line[x][j] = 0;
		}
		

		for (int i = 0; i < mak.length; i++) {
			for (int j = 0; j < mak[i].length; j++) {
				tmp[j][i] = line[i][j];
			}
		}
	}
	
}
