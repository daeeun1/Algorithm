package 소프티어;

import java.util.Scanner;

public class A더하기B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.printf("Case #%d: %d\n",tc+1, A+B);
        }
    }
}
