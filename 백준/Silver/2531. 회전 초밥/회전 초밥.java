 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+k-1];
		int[] tmp = new int[d+1];	
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if(i < k) {
				tmp[arr[i]]++;
				if(tmp[arr[i]] == 1) cnt++;
			}
		}
		// 회전초밥이니까 회전하는걸 표현. 
		for (int i = n; i < n+k-1; i++) {
			arr[i] = arr[i - n];
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(tmp));
		
		int max = cnt;
		
		for (int i = 1; i < n; i++) {
			// ex) k가 4일때 arr의 4번째 값을 tmp에 1증가시키고 
			tmp[arr[i+k-1]]++;
			if(tmp[arr[i+k-1]] == 1) cnt++;
			// arr의 0번째 값을 tmp에서 하나 뺍니다. 
			tmp[arr[i-1]]--;
			if(tmp[arr[i-1]] == 0) cnt--;
			
			if(tmp[c] == 0) {
				max = Math.max(max, cnt+1);
			}
			max = Math.max(max, cnt);
			
//			System.out.println(Arrays.toString(tmp));
//			System.out.println(cnt);
		}
		System.out.println(max);
	}

}
