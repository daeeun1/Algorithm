package dfs;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Boj11724_연결요소의개수 {
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N+1];
		v[0] = true;
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			adj[b].add(a);
		}
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int start) {
		if(!v[start]) {
			v[start] = true;
			for (int i = 0; i < adj[start].size(); i++) {
				if(!v[adj[start].get(i)]) dfs(adj[start].get(i));
			}
		}
		
	}

}
