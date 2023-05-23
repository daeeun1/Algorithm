package 백트랙킹;

import java.util.Scanner;

public class Boj2580_스도쿠 {
    static int N = 9;
    static int[][] sudoku = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }


    }
}
