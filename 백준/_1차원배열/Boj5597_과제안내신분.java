package _1차원배열;

import java.util.Scanner;

public class Boj5597_과제안내신분 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[31];
        for (int i = 0; i < 28; i++) {
            arr[sc.nextInt()]++;
        }
        for (int i = 1; i < 31; i++) {
            if(arr[i] != 1) System.out.println(i);
        }
    }
}
