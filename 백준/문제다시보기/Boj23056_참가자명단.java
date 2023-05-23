package 문제다시보기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj23056_참가자명단 {
    static class ClassMate implements Comparable<ClassMate>{
        int classNum;
        String name;

        public ClassMate(int classNum, String name) {
            this.classNum = classNum;
            this.name = name;
        }

        @Override
        public int compareTo(ClassMate o) {
            if (this.classNum == o.classNum) {
                if(this.name.length() == o.name.length()) return this.name.compareTo(o.name);
                return this.name.length() - o.name.length();
            }
            return this.classNum - o.classNum;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ClassMate> evenList = new ArrayList<>();
        ArrayList<ClassMate> oddList = new ArrayList<>();
        int[] arr = new int[N+1];
        while (true){
            int tmpNum = sc.nextInt();
            String tmpName = sc.next();

            if(tmpNum == 0 && tmpName.charAt(0) == '0') break;
            if(arr[tmpNum] >= M) continue;
            if(tmpNum % 2 != 0) {
                evenList.add(new ClassMate(tmpNum, tmpName));
            }
            else oddList.add(new ClassMate(tmpNum, tmpName));
            arr[tmpNum]++;
        }

        Collections.sort(evenList);
        Collections.sort(oddList);
        for (ClassMate classMate : evenList){
            System.out.println(classMate.classNum + " " + classMate.name);
        }
        for (ClassMate classMate : oddList){
            System.out.println(classMate.classNum + " " + classMate.name);
        }
    }
}
