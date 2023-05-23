package 문제다시보기;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10815_숫자카드 {
    static int[] NArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        NArr = new int[N];
        for (int i = 0; i < N; i++) {
            NArr[i] = sc.nextInt();
        }
        Arrays.sort(NArr);
        System.out.println(Arrays.toString(NArr));
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            if(binaryArr(NArr.length/2, NArr.length-1, 0, sc.nextInt())) {
                System.out.print("1 ");
            }
            else System.out.print("0 ");
        }

    }

    private static boolean binaryArr(int middle, int nMax, int nMin, int find) {
        int nMiddle = ( nMax + nMin ) / 2;
        while(nMax - nMin >= 0){
            if(NArr[nMiddle] == find) return true;
            else if (NArr[nMiddle] <= find) {
                nMin = nMiddle + 1;
                nMiddle = ( nMax + nMin ) / 2;
            }else {
                nMax = nMiddle - 1;
                nMiddle = ( nMax + nMin ) / 2;
            }
        }
        return false;
    }
}
