import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] dp, arr;
    static int n;
    static int INF = 100_000_000;
    static int MIN = 100_000_000;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][4];
        dp = new int[n+1][4];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // i 번째 집을 1번 색(Red)로 칠하는 비용
            arr[i][1] = R;
            arr[i][2] = G;
            arr[i][3] = B;
        }

        for (int color = 1 ; color <= 3 ; color ++) {
            // dp 배열 초기화
            for (int i = 1; i <= n; i++) {
                dp[i][1] = INF;
                dp[i][2] = INF;
                dp[i][3] = INF;
            }

            dp[1][color] = arr[1][color];

            // 색칠
            for(int i = 2; i <= n; i++) {
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][2], dp[i-1][3]);
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][3]);
                dp[i][3] = arr[i][3] + Math.min(dp[i-1][1], dp[i-1][2]);
            }

            // 1번과 n번은 달라야 함 ( 처음 고른 색을 제외한 나머지의 색 중 고르기 )

            // 1번 색을 골랐으면 2,3
            // 2번 색을 골랐으면 1,3
            // 3번 색을 골랐으면 1,2

            for (int lastColor = 1; lastColor <= 3; lastColor++) {
                if (lastColor != color) {
                    MIN = Math.min(MIN, dp[n][lastColor]);
                }
            }
        }
        System.out.println(MIN);
    }
}