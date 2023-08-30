import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	
	static int n, m;
	static int[][] Map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		
		for (int i = 1 ; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1 ; j <= m ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		dp[1][1] = Map[1][1];
		
		for (int i = 1 ; i <= n ; i ++) {
			for (int j = 1 ; j <= m ; j ++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + Map[i][j]; 
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
