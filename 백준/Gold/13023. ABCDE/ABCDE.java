import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 인접리스트
		adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a].add(b);
			adj[b].add(a);
		}
		result = 0;
//        System.out.println(Arrays.toString(adj));
		for (int i = 0; i <= N; i++) {
			v = new boolean[N+1];
			dfs(i, 1);
			if(result== 1)break;

		}

		System.out.println(result);
	}

	static boolean[] v;
	static int result;

	private static void dfs(int start, int k) {
		v[start] = true;
		 
		if(5 == k) {
			result = 1;
			return ;
		}

		for (int i = 0; i < adj[start].size(); i++) {
			if (!v[adj[start].get(i)]) {
				dfs(adj[start].get(i), k+1);
			}
		}
		v[start] = false ;
	}

}
