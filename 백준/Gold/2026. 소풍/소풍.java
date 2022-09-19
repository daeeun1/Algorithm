import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int K, N, F;
	static ArrayList<Integer>[] adj;
	static HashSet<Integer>[] isF;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		F = sc.nextInt();

		adj = new ArrayList[N + 1];
		isF = new HashSet[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			isF[i] = new HashSet<>();
		}

		for (int i = 0; i < F; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a].add(b);
			adj[b].add(a);
			isF[b].add(a);
			isF[a].add(b);

		}
		comb(1, 0, new int[K]);
		System.out.println(-1);
	}

	private static void comb(int idx, int cnt, int[] arr) {
		if (cnt == K) {
			if (isC(arr)) {
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (adj[i].size() < K - 1)
				continue;
			arr[cnt] = i;
			comb(i + 1, cnt + 1, arr);
		}
	}

	private static boolean isC(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				if (!isF[arr[i]].contains(arr[j])) {
					return false;
				}
			}
		}
		return true;
	}

}
