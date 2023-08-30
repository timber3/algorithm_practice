import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] time, money;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		// dp : 해당 날 까지의 최대값을 저장한다.
		dp = new int[17];
		time = new int[17];
		money = new int[17];
		
		for (int i = 1; i <= n ; i ++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n ; i >= 1 ; i--) {
			// 해당 날짜에 일을 할 수 있다면
			if (i + time[i] <= n+1 ) {
				dp[i] = Math.max(dp[i+1], dp[i+time[i]] + money[i]); 
			} else {
				dp[i] = dp[i+1]; 
			}
		}
		
		System.out.println(dp[1]);
	}
}
