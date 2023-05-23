package 백트랙킹;

import java.util.Scanner;

public class Boj7682_틱택토2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		while (!s.equals("end")) {
			String result = "invalid";
			char[][] tictactoc = new char[3][3];
			int[] xoCnt = new int[2]; // x, o의 각각의 개수를 체크하는 배열 x 가 0
			count = 0; // x, o의 개수를 체크하는 변수

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tictactoc[i][j] = s.charAt(i * 3 + j);
					if (tictactoc[i][j] == 'X') {
						count++;
						xoCnt[0]++;
					} else if (tictactoc[i][j] == 'O') {
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

			if (check(tictactoc, xoCnt)) {
				result = "valid";
			}

			System.out.println(result);
			s = sc.next();
		}
	}

	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int xCnt, oCnt, count;

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
								cnt++;
							}else {
								break;
							}
						}
//						System.out.println(cnt);
						if(cnt == 2) {
//							System.out.println(i + " " + j + " -------------- ");
							if(tictactoc[i][j] == 'X') {// && xoCnt[0] - xoCnt[1] == 1
								xCnt++;
							}else if(tictactoc[i][j] == 'O') {
								oCnt++;
							}
						}
					}
				}
			}
		}
		
		if (xCnt > 0 && oCnt > 0) return false;
		
		if(xoCnt[1] > xoCnt[0] || xoCnt[0] - xoCnt[1] > 1) return false;
		
		// 1-1 하나의 승리상태만 있을 경우 
		if(count != 9 ){
			if(xCnt > 0 && oCnt == 0 && xoCnt[0] - xoCnt[1] == 1) return true;
			else if(oCnt > 0 && xCnt == 0 && xoCnt[0] == xoCnt[1]) return true;
		}
		// 2-1
		else {
			if(xoCnt[0] - xoCnt[1] == 1) {
				if(xCnt > 0 && xCnt <= 4) return true;
				else if(xCnt == 0 && oCnt == 0) return true;
			}
		}
		
//		System.out.println("xCnt : " + xCnt + ", oCnt : " + oCnt);
		
		return false;
	}

	private static boolean checkLine(int nr, int nc) {
		return nr >= 0 && nr < 3 && nc >= 0 && nc < 3;
	}

}

// 오늘 할 일 다 찼을때랑 안찼을때로 구분해서 아예 빠지는 구멍 없게!!
// x의 개수랑 o의 개수가 1개나 0개 나는지 확인하고 한 사람이 성공했는지 확인하고
//if ((xoCnt[0] - xoCnt[1] == 1 || xoCnt[0] - xoCnt[1] == 0) && check(tictactoc, xoCnt)) { // 성공 했을때
//	result = "valid";
//	
//}else { // 성공하지 못했을 때 
//	
//	// 가득차고 x가 하나 많을 때
//	if (count == 9 && xoCnt[0] - xoCnt[1] == 1) {
//		result = "valid";
//	}
//}

//if(check(tictactoc, xoCnt)) {// 잇는 데 성공했을때
//	result = "valid";
//}else if(count == 9 && xoCnt[0] - xoCnt[1] == 1) {// 게임판이 가득찼을때
//	if(!check(tictactoc, xoCnt)) result = "valid";
//	else if(check(tictactoc, xoCnt) && (xCnt == 2 || xCnt == 4) && oCnt == 0) result = "valid";// 마지막에 놓는 곳이 성공했을때
//}
//else if() {
//	result = "invalid";
//}
//if(count == 9 && (xoCnt[0] - xoCnt[1] == 1 || xoCnt[0]-xoCnt[1] == 0)) result = "invalid";
