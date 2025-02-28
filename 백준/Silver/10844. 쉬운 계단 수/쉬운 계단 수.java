import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long sum;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        // 인접한 수의 차이가 1인 수
        n = Integer.parseInt(br.readLine());

        // dp 배열은 길이가 i 이면서 마지막 숫자가 j인 배열의 경우의 수임.
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
        // 0과 9는 예외 (마지막 자리가 0이려면 1에서 내려오는 것 밖에 없음 마찬가지로 마지막 자리가 9면 8에서 올라가는것 밖에 없음)
        // dp[i][0] = dp[i-1][1]
        // dp[i][9] = dp[i-1][8]

        dp = new long[n+1][10]; // 0~9까지

        for (int i = 1 ; i <= 9 ; i ++) {
            dp[1][i] = 1;
        }

        for (int i = 2 ; i <= n ; i ++) {
            for (int j = 0 ; j <= 9 ; j ++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][8];
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        for (int i = 0 ; i <= 9 ; i ++) {
            sum += (dp[n][i] % 1000000000);
        }

        System.out.println(sum % 1000000000);
    }
}
