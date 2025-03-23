import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static boolean[] dp;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dp = new boolean[n+1];

        // true : 상근이
        // false : 창영이
        dp[1] = true;
        if (n >= 3) dp[3] = true;
        if (n >= 2) dp[2] = false;

        if (n >= 4)
            for (int i = 4 ; i <= n ; i ++) {
                dp[i] = !dp[i-1] || !dp[i-3];
            }

        if (dp[n]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
