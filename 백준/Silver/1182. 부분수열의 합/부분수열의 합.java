import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		boolean[] sel = new boolean[arr.length];
		powerSet(0, arr, sel);
		if(s == 0)	System.out.println(result-1);
		else System.out.println(result);
	}

	static int s;
	static int result;

	private static void powerSet(int idx, int[] arr, boolean[] sel) {
		if (idx == arr.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					sum += arr[i];
				}
			}
			if(sum == s) result++;
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1, arr, sel);
		sel[idx] = false;
		powerSet(idx + 1, arr, sel);

	}

}
