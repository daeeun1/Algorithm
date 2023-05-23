package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jol2577_회전초밥2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+k-1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 회전초밥이니까 회전하는걸 표현. 
		for (int i = n; i < n+k-1; i++) {
			arr[i] = arr[i - n];
		}
		
//		System.out.println(Arrays.toString(arr));
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if(max == k+1) break;
			int cnt = 0;
			int[] tmp = new int[d+1];
			for (int j = i; j < i+k; j++) {
//				System.out.print(arr[j] + " ");
				if(tmp[arr[j]] == 0) {
					tmp[arr[j]] = 1;
					cnt ++;
				}
			}
			if (tmp[c] == 0 ) cnt++;
//			System.out.println();
			
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
