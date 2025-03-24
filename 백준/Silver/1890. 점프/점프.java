import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    static long[][] dp;

    // 아래 or 오른쪽
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        dp = new long[n+1][n+1];

        for (int i = 1 ; i <= n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1 ; j <= n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        // 가로줄 세로줄 초기화

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                if (i == n && j == n) break;
                if (j+map[i][j] <= n)
                    dp[i][j+map[i][j]] += dp[i][j];
                if (i+map[i][j] <= n)
                    dp[i+map[i][j]][j] += dp[i][j];
            }
        }

        System.out.println(dp[n][n]);


    }
}
