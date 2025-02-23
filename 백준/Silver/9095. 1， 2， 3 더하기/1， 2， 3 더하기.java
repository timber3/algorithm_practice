import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T, n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4 ; i <= 10 ; i ++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int t = 0 ; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}