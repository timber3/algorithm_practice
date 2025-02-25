import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            dp[i] = 99999999;
        }

        dp[1] = 0;
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 4) {
            for (int i = 4 ; i <= n ; i ++) {
                dp[i] = dp[i-1] + 1;

                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i/2] + 1, dp[i]);
                }
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i/3] + 1, dp[i]);
                }
            }
        }

        int target = n;

        while(target != 1) {
            sb.append(target).append(' ');
            if (dp[target] - 1 == dp[target-1]) {
                target = target - 1;
            }
            else if (target % 2 == 0 && dp[target] - 1 == dp[target/2]) {
                target = target / 2;
            }
            else if (target % 3 == 0 && dp[target] - 1 == dp[target/3]) {
                target = target / 3;
            }
        }

        sb.append(1);

        System.out.println(dp[n]);
        System.out.println(sb);
    }
}
