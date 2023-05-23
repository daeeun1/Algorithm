package 시뮬레이션;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	// 맨 윗 줄의 좌표
	static ArrayList<Loc>[] top, copyTop;
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			H = sc.nextInt();
			W = sc.nextInt();
			
			map = new int[W][H];
			boolean[] v = new boolean[H];
			result = 0;
			top = new ArrayList[H];
			for (int i = 0; i < H; i++) {
				top[i] = new ArrayList<>();
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
					if(!v[j] && map[i][j] != 0) {
						v[j] = true;
						top[j].add(new Loc(i, j));
					}
				}
			}
			
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("----------");
//			for (int i = 0; i < top.length; i++) {
//				System.out.println(top[i].toString());
//			}
			
			int[] arr = new int[H];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			// 구슬을 하나 없앨 때마다 한번 실행해야 합니다. 
			comb(0, new int[N], arr, 0);
		}
		
		
		
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int result;
	private static void comb(int idx, int[] sel, int[] arr, int k) {
		if(k == N) {
//			System.out.println(Arrays.toString(sel));
			
			// 중복 조합
			int[][] copyMap = map;
			copyTop = new ArrayList[H];
			for (int i = 0; i < H; i++) {
				copyTop[i] = top[i];
			}
			int cnt = 0;
			for (int i = 0; i < sel.length; i++) {
				
				int r = copyTop[sel[i]].get(0).x;
				int c = copyTop[sel[i]].get(0).y;
				
				if(copyMap[r][c] == 1) {
					// map 지워줘야 함
					copyMap[r][c] = 0;
					cnt ++;
					// remove해줘야하고 copyTop에
					copyTop[sel[i]].remove(0);
					// add 해줘야합니다. copyTop에
					copyTop[sel[i]].add(new Loc(r+1, c));
					System.out.println(r);
					System.out.println(copyTop[sel[i]].toString());
				}
				else {
					Queue<Loc> queue = new LinkedList<>();
					queue.add(new Loc(r, c));
					
					while(!queue.isEmpty()) {
						Loc tmp = queue.poll();
						
						// 그 안의 숫자만큼 while타야합니다.
						for (int a = 0; a < copyMap[tmp.x][tmp.y]-1; a++) {
							
							for (int d = 0; d < 4; d++) {
								int nr = tmp.x + dr[d];
								int nc = tmp.y + dc[d];
								
								if(d == 0 || d== 1) nr += a;
								else nc += a;
								// 여기까지 이제 사방으로 퍼지는거 까지 함. 
								// 퍼진 것들 표시 남겨야함 map 지워줘야함.
								if(check(nr, nc) && copyMap[nr][nc] != 0) {
									if(copyMap[nr][nc] == 1) {
										copyMap[nr][nc] = 0;
										cnt ++;
									}
									else {
										queue.add(new Loc(nr, nc));
									}
								}
							}
						}
						// map 지워줘야 함
						copyMap[tmp.x][tmp.y] = 0;
						cnt ++;
						
					}
					
				}
				
				
				
			}
			result = Math.max(result, cnt);
			System.out.println("result : " + result + ", cnt : " + cnt);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			comb(idx+1, sel, arr, k+1);
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < W && nc >= 0 && nc < W;
	}



}

