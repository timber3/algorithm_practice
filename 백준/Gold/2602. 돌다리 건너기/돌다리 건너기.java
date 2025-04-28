import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String str;
    static int n, m;
    static char[][] bridge;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {

        str = br.readLine();
        n = str.length();

        String angel = br.readLine();
        String demon = br.readLine();

        bridge = new char[2][];

        bridge[0] = angel.toCharArray();
        bridge[1] = demon.toCharArray();

        m = angel.length();

        dp = new int[n][2][m];

        // 처음 값 찾아서 초기화
        for (int i = 0 ; i < m ; i ++) {
            if (bridge[0][i] == str.charAt(0)) {
                dp[0][0][i] = 1;
            }
            if (bridge[1][i] == str.charAt(0)) {
                dp[0][1][i] = 1;
            }
        }


        for (int i = 0 ; i < n - 1 ; i ++) {
            for (int j = 0 ; j < 2 ; j ++) {

                int next = 1 - j;

                for (int k = 0 ; k < m ; k ++) {

                    if (dp[i][j][k] > 0) {
                        for (int t = k + 1 ; t < m ; t ++) {
                            // 반대편 다리의 t번째 문자가 목표 문자일 때
                            if (bridge[next][t] == str.charAt(i+1)) {
                                // 다음으로 갈 수 있으니 현재의 경우의 수를 더해주기
                                dp[i+1][next][t] += dp[i][j][k];
                            }
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0 ; i < m ; i ++) {
            sum += dp[n-1][0][i];
            sum += dp[n-1][1][i];
        }

        System.out.println(sum);

    }
}