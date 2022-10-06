 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, M;
	static class Shark{
		int r, c, speed, dist, size;

		public Shark(int r, int c, int speed, int dist, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dist = dist;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", dist=" + dist + ", size=" + size + "]";
		}
	}
	static int[][] map, copy;
	static ArrayList<Shark> list;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Queue<Integer> remove = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList<>();
		map = new int[R][C];
		for (int i = 0; i < M; i++) {
			list.add(new Shark(sc.nextInt()-1,sc.nextInt()-1, sc.nextInt(), sc.nextInt()-1, sc.nextInt()));
			
			// map에 상어 찍기
			map[list.get(i).r][list.get(i).c] = list.get(i).size;
		}
		//낚시왕 이동
//		print();
//		System.out.println();
		for (int i = 0; i < C; i++) {
			Catch(i);
//			print();
//			System.out.println();
			Move();
//			print();
//			System.out.println();
//			System.out.println("--------");
		}
		System.out.println(sum);
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int sum = 0;
	private static void Move() {
		// list에 있는 친구들을 움직입니다!!
//		System.out.println(list.toString());
		
		copy = new int[R][C];
		for (int i = 0; i < list.size(); i++) {
			Shark temp = list.get(i);
			
			for (int j = 0; j <temp.speed; j++) {
				if(temp.dist == 0 && temp.r == 0) temp.dist = 1;
				else if(temp.dist == 1 && temp.r == R-1) temp.dist = 0;
				else if(temp.dist == 2 && temp.c == C-1) temp.dist = 3;
				else if(temp.dist == 3 && temp.c == 0) temp.dist = 2;
				
				temp.r += dr[temp.dist];
				temp.c += dc[temp.dist];
			}
			
//			System.out.println(i +"번상어 : " + list.get(i).toString());
  		
			if(copy[temp.r][temp.c] == 0) {
				copy[temp.r][temp.c] = temp.size;
			}else if(copy[temp.r][temp.c] < temp.size) {
				remove.add(copy[temp.r][temp.c]);
				copy[temp.r][temp.c] = temp.size;
			}else {
				remove.add(temp.size);
			}
		}
		
		while(!remove.isEmpty()) {
			int tmp = remove.poll();
			for (int i = 0; i < list.size(); i++) {
				if(tmp == list.get(i).size) {
					list.remove(i);
					break;
				}
			}
			
		}
		map = copy;
	}

	private static void Catch(int c) {
		L: for (int r = 0; r < R; r++) {
			
			if(map[r][c] != 0) {
				for (int i = 0; i < list.size(); i++) {
					
					if(map[r][c] == list.get(i).size) {
						sum += list.get(i).size;
						list.remove(i);
						map[r][c] = 0;
						break L;
					}
				}
			}
		}
	}

}
