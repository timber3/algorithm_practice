import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new long[n+1];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 2;
        }
        if (n>=4) {
            for (int i = 4; i <= n ; i ++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[n]);
    }
}
