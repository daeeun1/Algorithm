package _1차원배열;

import java.util.Scanner;

public class Boj10813_공바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];

        for (int i = 0; i < N; i++) {
            arr[i+1] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();

            int tmp = arr[j];
            arr[j] = arr[k];
            arr[k] = tmp;
        }

        for (int i = 1; i < N+1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
