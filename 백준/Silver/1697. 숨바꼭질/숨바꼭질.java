import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if ( N == K) System.out.println(0);
		else bfs();
	}
	static int Ans;
	static int[] check = new int[100001];
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		check[N] = 1;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				if(i == 0)	next = n+1;
				else if(i == 1) next = n-1;
				else next = n*2;
				
				if(next == K) {
					System.out.println(check[n]);
					return;
				}
				
				if(next < 0 || next >= check.length || check[next] != 0) continue;
				
				queue.add(next);
				check[next] = check[n] + 1;
			}
		}
		
		
	}
	
	
	

}
