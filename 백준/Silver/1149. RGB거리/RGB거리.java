import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] dp;
	static int[][] cost;
	static int[] color;
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		cost = new int[1001][4];
		color = new int[1001];
		dp = new int[1001][4];
		
		// 빨강 초롱 파랑
		for (int i = 1 ; i <= n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <= 3 ; j ++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sum = 0;
		
		for (int i = 1 ; i <= n ; i++) {
			dp[i][1] = Math.min(dp[i-1][2] + cost[i][1], dp[i-1][3] + cost[i][1]);
			dp[i][2] = Math.min(dp[i-1][1] + cost[i][2], dp[i-1][3] + cost[i][2]);;
			dp[i][3] = Math.min(dp[i-1][1] + cost[i][3], dp[i-1][2] + cost[i][3]);;
		}
		
		int result = Math.min(Math.min(dp[n][1],dp[n][2]),dp[n][3]);
		
		System.out.println(result);
	}
}
