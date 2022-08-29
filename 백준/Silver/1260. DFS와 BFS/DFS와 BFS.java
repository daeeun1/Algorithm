import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adj[from].add(to);
			adj[to].add(from);
		}
		dfs(new boolean[N+1], start);
		System.out.println();
		bfs(start);
	}

	private static void dfs(boolean[] v, int start) {
		v[start] = true;
		System.out.print(start + " ");
		for (int i = 0; i < adj[start].size(); i++) {
			adj[start].sort(null);
			int tmp = adj[start].get(i);
			if(!v[tmp]) {
				dfs(v, tmp);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		boolean[] v = new boolean[N+1];
		v[start] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print(q + " ");
			
			for (int i = 0; i < adj[q].size(); i++) {
				adj[q].sort(null);
				int tmp = adj[q].get(i);
				if(!v[tmp]) {
					queue.add(tmp);
					v[tmp] = true;
				}
			}
			
		}
	}

}
