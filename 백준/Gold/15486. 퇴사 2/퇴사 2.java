import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] dp;
    static int[] cost, time;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new long[n+2];
        cost = new int[n+1];
        time = new int[n+1];

        for (int i = 1; i <= n ; i ++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }


        // dp : 그날까지 얻을 수 있는 최대 수익
        for (int i = 1 ; i <= n ; i ++) {
            // 상담을 안하고 넘어가는게 이득인 경우도 있음.
            dp[i] = Math.max(dp[i-1], dp[i]);

            // 마지막 날에 1일짜리 일을 할 수 있음
            if (i + time[i] <= n + 1) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + cost[i]);
            }
        }

//        for (int i = 1 ; i <= n+1 ; i ++) {
//            System.out.print(dp[i] + " ");
//        }

        System.out.println(Math.max(dp[n], dp[n+1]));

    }
}
