package 문제다시보기;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2999_비밀이메일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String algo = sc.nextLine();
        char[] arr = new char[100];
        int R = 1, C = algo.length();
        for (int i = 0; i < algo.length(); i++) {
            arr[i] = algo.charAt(i);
            if(algo.length()%(i+1) == 0){
                if((i+1) <= algo.length()/(i+1)){
                    R = i+1;
                    C = algo.length()/(i+1);
                }
            }
        }
//        System.out.println("R : " + R + ", C : " + C);

        char[][] map = new char[R][C];
        int num = 0, i = 0, j = 0;
        map[0][0] = arr[0];
        while (++num < algo.length()){
            if(num % R == 0){
                i = 0;
                map[i][++j] = arr[num];
//                System.out.println(map[i][j]+"  00   i " + i + " j " + j + "num " + num);
            }else {
                map[++i][j] = arr[num];
//                System.out.println(map[i][j]+"  11   i " + i + " j " + j + "num " + num);
            }
        }

        for (int a = 0; a < R; a++) {
            for (int b = 0; b < C; b++) {
                System.out.print(map[a][b]);
            }
        }
    }
}
