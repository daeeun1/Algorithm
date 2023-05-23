package _1차원배열;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10811_바구니뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];

        for (int i = 0; i < N; i++) {
            arr[i+1] = i+1;
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int[] tmpArr = new int[N+1];
            for (int l = 0; l < N; l++) {
                tmpArr[l+1] = arr[l+1];
            }

            int tmp = j;
            for (int l = i; l < j; l++) {
                tmpArr[l] = arr[tmp--];
            }
            tmpArr[j] = arr[i];

            for (int l = 0; l < N; l++) {
                arr[l+1] = tmpArr[l+1];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i+1] + " ");
        }
    }
}
