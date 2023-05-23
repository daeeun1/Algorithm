package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16236_아기상어 {
	static int N;
	static int[][] arr;
	static Queue<Shark> shark;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Shark {
		int x, y, dist;

		public Shark(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dist = cnt;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}


	}

	private static void bfs() {
		
        int eat = 0;
        int time = 0; 
        int age = 2;
		while (true) {
			ArrayList<Shark> fish = new ArrayList<>();
			int[][] dist = new int[N][N];
			
			while (!shark.isEmpty()) {
				Shark tmp = shark.poll();
				for (int d = 0; d < 4; d++) {
					int nr = tmp.x + dr[d];
					int nc = tmp.y + dc[d];

					// 경계선 안에 있고 크기가 작으면 이동할 수 있는 곳입니다.
					if (check(nr, nc) && arr[nr][nc] <= age && dist[nr][nc]==0 ) {
						dist[nr][nc] = dist[tmp.x][tmp.y] + 1;
						shark.add(new Shark(nr, nc, dist[nr][nc]));
						if(1 <= arr[nr][nc] && arr[nr][nc] <= 6 && arr[nr][nc] < age) fish.add(new Shark(nr, nc, dist[nr][nc]));
					}
				}
			}
			if(fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Shark currentFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if(currentFish.dist > fish.get(i).dist) {
                    currentFish = fish.get(i);
                }
                else if(currentFish.dist == fish.get(i).dist) {
                    if(currentFish.x > fish.get(i).x) currentFish = fish.get(i);
                    else if(currentFish.x == fish.get(i).x){
                        if(currentFish.y > fish.get(i).y) currentFish = fish.get(i);   
                    }
                } 
			}
			time += currentFish.dist;
            eat++;
            arr[currentFish.x][currentFish.y] = 0;
            if(eat == age) {
                age++;
                eat = 0;
            }
            shark.add(new Shark(currentFish.x, currentFish.y, 0));
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N][N];
		shark = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 9) {
					shark.add(new Shark(i, j, 0));
					arr[i][j] = 0;
				}
			}
		}
		bfs();
	}

}
