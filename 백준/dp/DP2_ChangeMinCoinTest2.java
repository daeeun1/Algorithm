package dp;
import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest2 {
	// 1, 4, 6원 화폐 단위로 고정
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); // 목표금액, 최대 십만원까지다.
		
		int[]D = new int[money + 1]; // D[i] : i금액을 만드는 최소 동전 수
		
		D[0] = 0;
		int INF = 100000; // +1처리시 오버플로우 발생하지 않는 값
		for (int i = 1; i <= money; i++) {
			int min = INF;
			min = Math.min(min, D[i-1] + 1); // 1원을 사용했을 때의 금액
			
			if(i >= 4) min = Math.min(min, D[i-4]+1); // 4원을 사용할 수 있으면
			if(i >= 6) min = Math.min(min, D[i-6]+1); // 6원을 사용할 수 있으면
			
			D[i] = min;
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]);
	}
}
