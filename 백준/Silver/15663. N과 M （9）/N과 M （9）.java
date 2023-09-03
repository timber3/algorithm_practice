import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr, result, nums;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[10001];
		arr = new int[n];
		result = new int[m];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			int idx = Integer.parseInt(st.nextToken());
			nums[idx] += 1;
			
			if(nums[idx]>1) continue;
			arr[i] = idx; 
		}
		
		Arrays.sort(arr);
		
		combi(0, 0);
		
		System.out.print(sb);
		
	}
	
	static void combi(int cnt, int idx) {
		if (cnt == m) {
			for (int i = 0 ; i < m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			
			return;
		}
		
		for (int i = 0 ; i < n ; i ++ ) {
			if(nums[arr[i]] > 0) {
				nums[arr[i]]--;
				result[cnt] = arr[i];
				combi(cnt+1, i+1);
				nums[arr[i]]++;
			}
		}
	}
	
}
