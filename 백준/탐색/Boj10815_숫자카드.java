package 탐색;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10815_숫자카드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int M = sc.nextInt();
        int[] sel = new int[M];
        for (int i = 0; i < M; i++) {
            sel[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {

            int result = 0;
            int left = 0;
            int right = N-1;
            while (left <= right){
                int mid = (right + left) / 2;

                if (sel[i] < arr[mid]){
                    right = mid - 1;
                } else if (sel[i] > arr[mid]) {
                    left = mid + 1;
                }else {
                    result = 1;
                    break;
                }
            }
            System.out.print(result + " ");

        }
    }
}
