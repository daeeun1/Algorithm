package 시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj14503_로봇청소기 {
	static int N, M, count, r, c, dist;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1}; 
	static int[] dc = {-1, 0, 1, 0};
	
	private static void clean() {
		int twoCnt = 0;
		
		while(true) {
			print();
			// 1. 현재 위치를 청소한다
			if(arr[r][c] == 0) {
				count++;
				arr[r][c] = 2;
			}
			
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색을 진행한다.
			int nr = r, nc = c;
			if(dist == 0) {
				nr += dr[0];
				nc += dc[0];
			}else if(dist == 1) {
				nr += dr[3];
				nc += dc[3];
			}else if(dist == 2) {
				nr += dr[2];
				nc += dc[2];
			}else if(dist == 3) {
				nr += dr[1];
				nc += dc[1];
			}
			
			// 2-1 현재 방향에서 왼쪽이 0이면 회전한 다음 전진하고 처음으로 돌아갑니다.
			if(arr[nr][nc] == 0) {
				if(dist == 0) dist = 4;
				else if(dist == 1) dist = 0;
				else if(dist == 2) dist = 1;
				else if(dist == 3) dist = 2;
				r = nr;
				c = nc;
				twoCnt = 0;
				continue;
			} 
			if(arr[nr][nc] != 0 && twoCnt != 4) { // 2-2 왼쪽에 청소할 공간이 없다면 회전만
				if(dist == 0) dist = 4;
				else if(dist == 1) dist = 0;
				else if(dist == 2) dist = 1;
				else if(dist == 3) dist = 2;
				twoCnt++;
				continue;
			}
			
			// 2-3 네 방향 모두 청소가 이미 되어 있거나 벽인 경우에는 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로
			if(twoCnt == 4 ) {
				if(dist == 0) {
					nr += dr[2];
					nc += dc[2];
				}
				if(dist == 1) {
					nr += dr[3];
					nc += dc[3];
				}
				if(dist == 2) {
					nr += dr[0];
					nc += dc[0];
				}
				if(dist == 3) {
					nr += dr[1];
					nc += dc[1];
				}
				if(arr[nr][nc] != 1) {
					r = nr;
					c = nc;
					twoCnt = 0;
					continue;
				}
			}
			
			// 2-4
			break;
			
		}
	}
	
	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		dist = sc.nextInt();
		
		arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
//				if(arr[i][j] == 0) count++;
			}
		}
		
		clean();
		System.out.println(count);
	}

	

}
