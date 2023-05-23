package 시뮬레이션;

import java.util.Scanner;

public class Sw4014_활주로건설 {
	static int N, X;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			int[][] arr = new int[N+1][N+1];
			int[][] arr2 = new int[N+1][N+1];
			
			for (int i = 0; i < N; i++) {
				
				// 그 줄의 최대 값
				int rowMax = 0;
				for (int j = 0; j < N; j++) {
					arr2[j][i] = arr[i][j] = sc.nextInt();
					rowMax = Math.max(rowMax, arr[i][j]);
				}
				arr[i][N] = rowMax;
			}
			
			for (int i = 0; i < arr2.length; i++) {
				int max = 0;
				for (int j = 0; j < arr2.length; j++) {
					max = Math.max(arr2[i][j], max); 
				}
				arr2[i][N] = max;
			}
			
//			print(arr);
//			print(arr2);
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				if(process(arr[i])) result++;
				if(process(arr2[i])) result++;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	

	private static boolean process(int[] road) {
		int before = road[0], size= 0;
		int j = 0;
		
		while(j < N) {
			
			if(before == road[j]) {
				size ++;
				j++;
			}else if( before+1 == road[j]) { // 오르막 경사로 설치 체킄
				if(size < X) return false;
			
				before++;
				size = 1;
				j++;
			}else if(before -1 == road[j]) { // 내리막 경로
				
				int count = 0;
				for (int i = j; i < N; i++) {
					if(road[i] != before-1) return false;
					if(++count == X) break;
				}
				
				if(count < X) return false;
				
				before--;
				j += X;
				size = 0;
			}else {
				return false;
			}
		}
		return true;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}


}
