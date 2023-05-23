package 시뮬레이션;

import java.util.Scanner;

public class Boj20057_마법사상어와토네이도 {
	static int N;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	
	/*
	 * 1. 배열 돌리기
	 * 2. 모래 흩어지게 하기
	 * 	2-1 해당 비율로 모래 이동시키고
	 * 	2-2 남은 양 다음 이동지로 이동시키고
	 * 	2-3 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
//		System.out.println(start);
		tornado();
//		check(2, 2, 0, 10);
		System.out.println(sum);
	}


	private static void tornado() {
		int locX = N/2;
		int locY = N/2;
		int lenCnt = 0, d = 0;
		int len = 1;
		sum = 0;
		//!(locX == 0 && locY == 0)
		L: while(true) {
			
			d = d % 4;
			int nr = locX;
			int nc = locY;
			for (int i = 0; i < len; i++) {
				if(nr == 0 && nc == 0) break L;
				
				nr += dr[d];
				nc += dc[d];
//				System.out.println("nr : " + nr + ", nc : " + nc); 위치 찍는거
				// 이제 흩어지는 모래 양 검사하면 됩니다.
				if(arr[nr][nc] > 0) check(nr, nc, d, arr[nr][nc]);
			}

			locX = nr;
			locY = nc;
			d++;
			lenCnt = lenCnt++ > 0 ? 0 : 1;
			len = lenCnt == 0 ? len+1 : len;
//			System.out.println("lenCnt : " + lenCnt);
//			System.out.println("len : " + len);
//			System.out.println();
		}
		
	}
							// 2 		5		2		10		7		1		10		7		1
	static int[][] dZero = {{-2,0}, {0, -2}, {2, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}};
	static int[][] dOne = {{0,-2}, {2, 0}, {0, 2}, {1, -1}, {0, -1}, {-1, -1}, {1, 1}, {0, 1}, {-1, 1}};
	static int[][] dTwo = {{2,0}, {0, 2}, {-2, 0}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
	static int[][] dThree = {{0, 2}, {-2, 0}, {0,-2}, {-1, 1}, {0, 1}, {1, 1}, {-1, -1}, {0, -1}, {1, -1}};
	static int[] per = {2, 5, 2, 10, 7, 1, 10, 7, 1};
	static int sum;
	
	private static void check(int r, int c, int d, int sand) {
		// 1. 모래 이동
		int tmp = sand;
		if(d == 0) {
			for (int i = 0; i < dZero.length; i++) {
				int nr = r + dZero[i][0];
				int nc = c + dZero[i][1];
				if(boundryCheck(nr, nc)) {
//					System.out.println(sand*per[i]/100);
					arr[nr][nc] += sand*per[i]/100;
				}else {
					sum += sand*per[i]/100;
				}
				tmp -= sand*per[i]/100;
			}
		}else if(d == 1) {
			for (int i = 0; i < dOne.length; i++) {
				int nr = r + dOne[i][0];
				int nc = c + dOne[i][1];
				if(boundryCheck(nr, nc)) {
					arr[nr][nc] += sand*per[i]/100;
				}else {
					sum += sand*per[i]/100;
				}
				tmp -= sand*per[i]/100;
			}
		}else if(d == 2) {
			for (int i = 0; i < dTwo.length; i++) {
				int nr = r + dTwo[i][0];
				int nc = c + dTwo[i][1];
				if(boundryCheck(nr, nc)) {
					arr[nr][nc] += sand*per[i]/100;
				}else {
					sum += sand*per[i]/100;
				}
				tmp -= sand*per[i]/100;
			}
		}else if(d == 3) {
			for (int i = 0; i < dThree.length; i++) {
				int nr = r + dThree[i][0];
				int nc = c + dThree[i][1];
				if(boundryCheck(nr, nc)) {
					arr[nr][nc] += sand*per[i]/100;
				}else {
					sum += sand*per[i]/100;
				}
				tmp -= sand*per[i]/100;
			}
		}
		sand = tmp;
		
		// 2. 남은양 a자리로 이동
		int nr = r + dr[d];
		int nc = c + dc[d];
		if(boundryCheck(nr, nc)) arr[nr][nc] += sand;
		else sum += sand;
		
		// 3. r, c의 자리 0으로 만들기
		arr[r][c] = 0;
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}


	private static boolean boundryCheck(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
