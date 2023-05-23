package 반복문;

import java.util.Scanner;

public class Boj25314_코딩은체육과목입니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int num = N / 4;
        for (int i = 0; i < num; i++) {
            sb.append("long ");
        }
        System.out.println(sb + "int");
    }
}
