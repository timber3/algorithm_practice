import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr, result;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		result = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
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
		
		for (int i = idx ; i < n ; i ++ ) {
			result[cnt] = arr[i]; 
			combi(cnt+1, i);
		}
	}
	
}
