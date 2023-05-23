package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Boj14503_로봇청소기 {
	static int N, M, count, D;
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1};

	private static void clean(int r, int c) {
		// 현재 위치를 청소한다.
		if(arr[r][c] == 0) {
			arr[r][c] = 2;
			count++;
//			print();
//			System.out.println();
		}
		
		// 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 탐색
		for (int d = 0; d < 4; d++) {
			
			int dist = (D + 3)% 4;
			D = dist;
			int nr = r + dr[dist];
			int nc = c + dc[dist];
			if(arr[nr][nc] == 0) {
				clean(nr, nc);
				return ; 
			}
		}
		
		// 2-3 청소 되어 있거나 벽인 경우 한칸 후진
		int x = r+dr[(D+2)%4];
		int y = c+dc[(D+2)%4];
		if(arr[x][y] != 1) clean(x, y);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		D = sc.nextInt();
		
		arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
//				if(arr[i][j] == 0) count++;
			}
		}
		
		clean(r, c);
		System.out.println(count);
	}
	
	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
