package 문제다시보기;

import java.util.*;

public class Boj20551_Sort마스터배지훈의후계자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] MArr = new int[M];

        for (int i = 0; i < N + M; i++) {
            if(i < N) A[i] = sc.nextInt();
            else MArr[i-N] = sc.nextInt();
        }

        Arrays.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], i);
            }
        }

        for(int i : MArr){
            if(map.containsKey(i)) System.out.println(map.get(i));
            else System.out.println(-1);
        }

    }
}
