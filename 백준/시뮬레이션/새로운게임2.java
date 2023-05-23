package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 새로운게임2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][]arr =new int[N+2][N+2];
		for(int i =0; i<N+2; i++) {
			arr[i][0] = 2;
			arr[0][i] = 2;
			arr[N+1][i] = 2;
			arr[i][N+1] = 2;
		}
		Deque<Integer>[][]dq = new ArrayDeque[N+2][N+2];
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dq[i][j]  =new ArrayDeque<Integer>();
			}
		}
		int[][]play = new int[K][3];
		for(int i =0; i< K ;i++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			play[i][0] = x;
			play[i][1] = y;
			play[i][2] = Integer.parseInt(st.nextToken());//→, ←, ↑, ↓의
			dq[x][y].addLast(i);
		}
		int []di = new int[] {0,0,0,-1,1};
		int [] dj = new int[] {0,1,-1,0,0};
		int time = 1; 
		loop:
		while(time<1001) {
			for(int i =0; i< K ;i++) {
				int x= play[i][0];
				int y= play[i][1];
				if(arr[x+di[play[i][2]]][y+dj[play[i][2]]]==2) {
					play[i][2] = play[i][2]==1?2:play[i][2]==2?1:play[i][2]==3?4:3;
				}
				int d = play[i][2];
				int xx= x+di[d];
				int yy = y+dj[d];
				if(arr[xx][yy]==2) {
					continue;
				}
				switch(arr[xx][yy]) {
				case 0:
					int size = dq[x][y].size();
					boolean flag = false;
					for(int s = 0; s< size; s++) {
						int a = dq[x][y].pollFirst();
						if(a==i)flag = true;
						if(flag) {
							dq[xx][yy].addLast(a);
							play[a][0] = xx;
							play[a][1]= yy;
						}else {
							dq[x][y].addLast(a);
						}
					}
					break;
				case 1:
					while(!dq[x][y].isEmpty()) {
						int a = dq[x][y].pollLast();
						dq[xx][yy].addLast(a);
						play[a][0] = xx;
						play[a][1] =yy;
						if(a==i)break;
					}
				}
				if(dq[xx][yy].size()>3)break loop;
			}
			time++;
		}
		System.out.println(time==1001?-1:time);
		
	}

}
