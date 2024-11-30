import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {

            int n = Integer.parseInt(br.readLine());

            map = new int[2][n];
            dp = new int[2][n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0 ; i < n ; i ++) {
                map[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0 ; i < n ; i ++) {
                map[1][i] = Integer.parseInt(st.nextToken());
            }

            //input
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if (n >= 2) {
                dp[0][1] = dp[1][0] + map[0][1];
                dp[1][1] = dp[0][0] + map[1][1];
            }

            if ( n >= 3 ) {
                for (int i = 2 ; i < n ; i ++) {
                    dp[0][i] = Math.max(map[0][i] + dp[1][i-1], map[0][i] + dp[1][i-2]);
                    dp[1][i] = Math.max(map[1][i] + dp[0][i-1], map[1][i] + dp[0][i-2]);
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

        }
    }

}