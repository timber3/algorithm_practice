import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] dp = new int[5001];
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		
		dp[1] = 9999;
		dp[2] = 9999;
		dp[3] = 1;
		dp[4] = 9999;
		dp[5] = 1;
		
		
		
		for (int i = 6 ; i <= n ; i ++) {
			
			dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
			
		}
		
		if (dp[n]== 0 || dp[n] >= 9999 )
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}

}
