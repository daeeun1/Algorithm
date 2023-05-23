package 백트랙킹;

import java.util.Scanner;

public class Boj7682_틱택토 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		while(!s.equals("end")) {
			String result = "invalid";
			char[][] tictactoc = new char[3][3];
			int[] xoCnt = new int[2]; // x, o의 각각의 개수를 체크하는 배열 x 가 0 
			int count = 0; // x, o의 개수를 체크하는 변수
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tictactoc[i][j] = s.charAt(i*3+j);
					if(tictactoc[i][j] == 'X') {
						count ++;
						xoCnt[0]++;
					}else if(tictactoc[i][j] == 'O') {
						count++;
						xoCnt[1]++;
					}
				}
			}
			
			// xoCnt에서 0과 1의 차이가 1보다 크면 invalid
//			if(Math.abs(xoCnt[0] - xoCnt[1]) > 1) {
//				result = "invalid";
//			}else if(count == 9 && xoCnt[1] > xoCnt[0]) { // 9인데 x가 더 많으면 
//				result = "invalid";
//			}else 
				
			
			
			// 오늘 할 일 다 찼을때랑 안찼을때로 구분해서 아예 빠지는 구멍 없게!!
			
			
			if(check(tictactoc, xoCnt)) {// 잇는 데 성공했을때
				result = "valid";
			}else if(count == 9 && xoCnt[0] - xoCnt[1] == 1) {// 게임판이 가득찼을때
				if(!check(tictactoc, xoCnt)) result = "valid";
				else if(check(tictactoc, xoCnt) && (xCnt == 2 || xCnt == 4) && oCnt == 0) result = "valid";// 마지막에 놓는 곳이 성공했을때
			}
//			else if() {
//				result = "invalid";
//			}
//			if(count == 9 && (xoCnt[0] - xoCnt[1] == 1 || xoCnt[0]-xoCnt[1] == 0)) result = "invalid";
			
			System.out.println(result);
			s = sc.next();
		}
	}

	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	static int xCnt, oCnt;
	private static boolean check(char[][] tictactoc, int[] xoCnt) {
		xCnt = 0;
		oCnt = 0;
		
		for (int i = 0; i < tictactoc.length; i++) {
			for (int j = 0; j < tictactoc[i].length; j++) {
				
				if(tictactoc[i][j] != '.') {
					for (int d = 0; d < 8; d++) {
						int nr = i;
						int nc = j;
						int cnt = 0; // 3개가 되면 가능한 것입니다.
						while(true) {
//							System.out.println();
//							System.out.println(nr + " : " + nc);
							nr += dr[d];
							nc += dc[d];
							if(checkLine(nr, nc) && tictactoc[i][j] == tictactoc[nr][nc]) {
								cnt ++;
							}else {
								break;
							}
						}
//						System.out.println(cnt);
						if(cnt == 2) {
//							System.out.println(i + " " + j + " -------------- ");
							if(xoCnt[0] - xoCnt[1] <= 1) {
								if(tictactoc[i][j] == 'X') {// && xoCnt[0] - xoCnt[1] == 1
									xCnt ++;
								}else if(tictactoc[i][j] == 'O') {
									oCnt++;
								}
							}
						}
					}
				}
			}
		}
//		System.out.println("xCnt : " + xCnt + ", oCnt : " + oCnt);
		if(xCnt > 0 && oCnt == 0 && xoCnt[0] - xoCnt[1] == 1) {
//			System.out.println(1);
			return true;
		}
		else if(oCnt > 0 && xCnt == 0 && xoCnt[0] == xoCnt[1]) return true;
		return false;
	}
	private static boolean checkLine(int nr, int nc) {
		return nr >= 0 && nr < 3 && nc >= 0 && nc < 3;
	}

}
