import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, T;
	static int[] dp1, dp0;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < T ; t ++) {

			n = Integer.parseInt(br.readLine());
			dp1 = new int[41];
			dp0 = new int[41];
			
			dp1[0] = 0;
			dp1[1] = 1;
			dp0[0] = 1;
			dp0[1] = 0;
			
			for (int i = 2 ; i <= n ; i ++) {
				dp1[i] = dp1[i-1] + dp1[i-2];
				dp0[i] = dp0[i-1] + dp0[i-2]; 
			}
			
			System.out.println(dp0[n] + " " + dp1[n]);
		}
	}
}