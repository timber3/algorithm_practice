import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[10001][4];

        for (int i = 1 ; i <= 3 ; i ++) {
            dp[0][i] = 1;
        }

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1 ; i <= 10000; i ++) {
            for (int j = 1 ; j <= 3 ; j ++) {
                if (i - j >= 0)
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            sb.append(dp[arr[i]][3]).append('\n');
        }

        System.out.println(sb);

    }
}
