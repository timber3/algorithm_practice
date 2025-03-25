import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (n >= 2)
            dp[2] = dp[1] + arr[2];
        if (n >= 3)
            dp[3] = Math.max(arr[1] + arr[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));

        if (n >= 4)
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1],
                        Math.max(dp[i - 2] + arr[i],
                                dp[i - 3] + arr[i - 1] + arr[i]));
            }

        System.out.println(dp[n]);
    }
}
