import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, w, max;
    static int[] jadu;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        jadu = new int[t+1];
        dp = new int[t+1][w+1];

        for (int i = 1 ; i <= t; i ++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1 ; i <= t ; i ++) {
            for (int j = 0 ; j <= w ; j ++) {

                // 현재 위치 1 or 2
                int cur = (j % 2) + 1;

                int getJadu = 0;
                // 만약 다음 떨어지는 자두가 나랑 위치가 같으면 jadu 하나 얻기
                if (jadu[i] == cur) {
                    getJadu = 1;
                }

                // 그자리에서 그대로 받아먹었을 경우
                dp[i][j] = dp[i-1][j] + getJadu;

                // 자리를 옮겼을 경우
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + getJadu);
                }
            }
        }

        for (int i = 0 ; i <= w ; i ++) {
            if( dp[t][i] > max ) max = dp[t][i];
        }

        System.out.println(max);
    }
}