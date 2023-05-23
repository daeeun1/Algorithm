package 시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class Sw보호필름 {
	static int D, W, K;
	static int[][] arrD, arrW;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			arrD = new int[D][W];
			arrW = new int[W][D];
			for (int i = 0; i < arrD.length; i++) {
				for (int j = 0; j < arrD[i].length; j++) {
					arrD[i][j] = sc.nextInt();
				}
			}
			
			int sel = 0;
			boolean isOk = true;
			while(sel < D) {
				isOk = true; 
				
				if(sel > 0) {
					int[][] tmp = new int[D][W];
					
					for (int i = 0; i < arrD.length; i++) {
						for (int j = 0; j < arrD[i].length; j++) {
							tmp[i][j] = arrD[i][j];
						}
					}
					
					check(new boolean[D], new int[sel], 0, tmp);
				}
				
				
				
				// 검사 코드 시작
				for (int i = 0; i < W; i++) {
					
					int col = 0, colMax = 0;
					for (int j = 0; j < D; j++) {
						arrW[i][j] = arrD[j][i];
						if(j > 0) {
							if(arrW[i][j-1] == arrW[i][j]) {
								col++;
							}else col = 0;
						}
						
						colMax = Math.max(colMax, col);
					}
					if(colMax < K) isOk = false;
					if(!isOk) break;
//					System.out.println(Arrays.toString(arrW[i]));
				}	// 검사코드 끝
				
				System.out.println();
				// 성공하면 나가기
				if(isOk) break;
				else sel++; // 실패하면 sel 하나 증가
			}
			System.out.println(sel);
		}
	}

	private static void check(boolean[] v, int[] sel, int idx, int[][] tmp) {
		if(sel.length == idx) {
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				// 0 채우기, 1 채우기 해야합니다.
				Arrays.fill(tmp[sel[i]], 0);
			}
			check(v, sel, idx, tmp);
			
			return;
		}
		
		for (int i = 0; i < v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i;
				check(v, sel, idx+1, tmp);
				v[i] = false;
			}
		}
	}

}
