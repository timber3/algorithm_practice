import java.util.*;
import java.io.*;


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, T;
	static int[] t, s;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		t = new int[n + 1];
		s = new int[n + 1];
		
		dp = new int[n+1][T+1];
		
		for (int i = 1 ; i <= n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		// 문제
		for (int i = 1 ; i <= n ; i ++) {
			// 배점
			for (int j = 1; j <= T ; j ++) {
				if (j-t[i] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- t[i]] + s[i]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[n][T]);
		
	}
}