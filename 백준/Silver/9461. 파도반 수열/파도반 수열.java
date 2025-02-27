import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, T;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4 ; i <= 100 ; i ++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int t = 0 ; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}
