import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T;
	static int n;
	static int[] chu;
	static boolean[] visited;
	static int result, chuSum;

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());

			chu = new int[n];
			visited = new boolean[n];
			
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				chuSum += chu[i];
			}
			
			dfs(0, chuSum, 0, 0);
			

			System.out.printf("#%d %d\n", t+1, result);
			result = 0; chuSum = 0;
		}
	}

	static void dfs(int cnt, int remain, int lSum,  int rSum) {
        if (lSum >= rSum + remain) {
            int sum = 1;
             
            for (int i = 0; i < n - cnt; i++)
                sum *= 2;
            for (int i = 1; i <= n - cnt; i++)
                sum *= i;
            result += sum;
             
            return;
        }

		if (cnt == n) {
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			
			if (!visited[i])
			{
				visited[i] = true;
				dfs(cnt + 1, remain - chu[i], lSum + chu[i], rSum);
				
				if (rSum + chu[i] <= lSum)
				{
					dfs(cnt + 1, remain - chu[i], lSum, rSum + chu[i]);
				}
				visited[i] = false;				
			}
		}
	}
}
