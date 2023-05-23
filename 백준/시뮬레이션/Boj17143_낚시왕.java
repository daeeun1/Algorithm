package 시뮬레이션;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj17143_낚시왕 {
	static int R, C, M;
	static int[][] arr, copy;
	static int r, c, s, d, z;
	static class Shark{
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
	
	static Queue<Integer> remove = new LinkedList<>();
	static ArrayList<Shark> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[R+1][C+1];
		for (int i = 0; i < M; i++) {
			list.add(new Shark(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
			// 상어 위치 arr위에 나타내기
			arr[list.get(i).r][list.get(i).c] = list.get(i).z;
		}
//		System.out.println(list.get(0));
//		print();
		for (int i = 1; i<= C; i++) {
			Catch(i);
			
			Move();
//			print();
//			System.out.println("---------  sum : " + sum);
		}
		System.out.println(sum);
//		print();
	}
	
	private static void Move() {
		copy = new int[R+1][C+1];
		
		for (int i = 0; i < list.size(); i++) {
			Shark temp = list.get(i);
			arr[temp.r][temp.c] = 0;
			
			for (int j = 0; j < temp.s; j++) {
				
				if(temp.d == 1 && temp.r == 1) temp.d = 2;
				else if(temp.d == 2 && temp.r == R) temp.d = 1;
				else if(temp.d == 3 && temp.c == C) temp.d = 4;
				else if(temp.d == 4 && temp.c == 1) temp.d = 3;
				
				temp.r += dr[temp.d];
				temp.c += dc[temp.d];
			}
			
			if(copy[temp.r][temp.c] == 0) {
				copy[temp.r][temp.c] = temp.z;
			}else if(copy[temp.r][temp.c] < temp.z) {
				remove.add(copy[temp.r][temp.c]);
				copy[temp.r][temp.c] = temp.z;
			}else {
				remove.add(temp.z);
			}
			
		}
		
		while(!remove.isEmpty()) {
			int tmp = remove.poll();
			for (int i = 0; i < list.size(); i++) {
				if(tmp == list.get(i).z) {
					list.remove(i);
					break;
				}
			}
			
		}
		arr = copy;
	}

	private static void Catch(int y) {
		L : for (int x = 1; x <= R; x++) {
			if(arr[x][y] != 0) {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).r == x && list.get(i).c == y) {
						sum+=list.get(i).z;
						arr[x][y] = 0;
						list.remove(i);
						break L;
					}
				}
			}
		}
	}

	static int sum = 0;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	private static void print() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}













