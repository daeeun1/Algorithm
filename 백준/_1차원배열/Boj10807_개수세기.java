package _1차원배열;

import java.util.Scanner;

public class Boj10807_개수세기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[201];

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if (tmp < 0) tmp += 201;
            arr[tmp]++;
        }
        int result = sc.nextInt();
        if(result >= 0)System.out.println(arr[result]);
        else System.out.println(arr[result+201]);
    }
}
