import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[][] tri;
	static int[][] dp;
	static int Max;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		tri = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for (int i = 1 ; i <= n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j < i+1 ; j ++ ) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = tri[1][1];
		
		// 삼각형 가장자리 부분 dp 값 채워넣기
		for (int i = 2 ; i <= n ; i ++) {
			dp[i][1] = dp[i-1][1] + tri[i][1];
			dp[i][i] = dp[i-1][i-1] + tri[i][i];   
		}
		
		for (int i = 3 ; i <= n ; i ++) {
			for (int j = 2 ; j < i ; j ++ ) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
			}
		}
		
		for (int i = 1 ; i <= n ; i++) {
			if (dp[n][i] > Max) {
				Max = dp[n][i];
			}
		}
		
		System.out.println(Max);
		
	}
}
