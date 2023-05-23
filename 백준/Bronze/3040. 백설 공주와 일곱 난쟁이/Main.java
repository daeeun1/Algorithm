import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		answer = new int[7];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] sel = new int[7];
		prew(sel, 0, 0);
		if (answer[0] == -1) {

		}
	}

	private static void prew(int[] sel, int idx, int k) {
		if (sel.length == k) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if (sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			prew(sel, i + 1, k + 1);
		}
	}
}
