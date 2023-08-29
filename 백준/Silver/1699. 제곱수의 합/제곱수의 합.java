import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] dp;
	static ArrayList<Integer> nums; 
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		dp = new int[110001];
		nums = new ArrayList<>();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		
		for (int i = 5 ; i <= 110000 ; i ++) {
			dp[i]= Integer.MAX_VALUE; 
		}
		
		// 제곱수들은 전부 1로 넣어 줌.
		for (int i = 2; i <= 317; i ++) {
			nums.add(i*i);
			
			dp[i*i] = 1; 
		}
		
		for (int i = 5; i <= n ; i ++) {
			if (dp[i] == 1) continue;
			
			for (int j = 0 ; nums.get(j) <= i; j ++) {	
				dp[i] = Math.min(dp[i],Math.min(dp[i-1] + 1, (dp[nums.get(j)] + dp[i - nums.get(j)])));
			}
		}
		
		System.out.println(dp[n]);
		
	}
}
