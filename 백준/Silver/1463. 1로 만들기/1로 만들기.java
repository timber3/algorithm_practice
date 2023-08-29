import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i = 4 ; i <= n ; i++ ) {
			if (i % 3 == 0 ) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
			if (i % 2 == 0 ) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i]); 
			}
			dp[i] = Math.min(dp[i], dp[i-1] + 1);
		}
		
		System.out.println(dp[n]);
	}
}
