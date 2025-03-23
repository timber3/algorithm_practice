import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        dp[0] = 0;

        for (int i = 1 ; i <= n ; i ++) {
            dp[i] = i;
            for (int j = 1 ; j * j <= i ; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
