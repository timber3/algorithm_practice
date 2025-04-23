import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, n, m;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());

            coin = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i ++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            dp = new int[m+1];

            dp[0] = 1;

            // 모든 동전을 사용해서
            for (int i = 0 ; i < n ; i ++) {
                // 만들 수 있는 조합 전부 확인
                for (int j = coin[i] ; j <= m ; j ++) {
                    dp[j] += dp[j - coin[i]];
                }
            }

            System.out.println(dp[m]);
        }
    }
}