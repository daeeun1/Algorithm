package 반복문;

import java.util.Scanner;

public class Boj25304_영수증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int tmp_price = sc.nextInt();
            int tmp_num = sc.nextInt();

            price -= tmp_price * tmp_num;
        }
        if(price == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
