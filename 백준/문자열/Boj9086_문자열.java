package 문자열;

import java.util.Scanner;

public class Boj9086_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String tmp = sc.next();
            System.out.println(tmp.charAt(0) + "" + tmp.charAt(tmp.length()-1));
        }
    }
}
