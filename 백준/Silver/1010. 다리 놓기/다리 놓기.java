import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, T;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int t= 0 ; t < T ; t ++) {

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			dp = new int[32][32];

			for (int i = 1 ; i <= 31 ; i ++) {
				dp[i][1] = 1;
				dp[i][i] = 1; 
			}

			for (int i = 3 ; i <= end+1 ; i ++) {
				for (int j = 2 ; j < i ; j ++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}

			System.out.println(dp[end+1][start+1]);

		}
	}
}
