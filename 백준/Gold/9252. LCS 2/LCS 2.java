import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] arr1, arr2;
    static int[][] dp;
    static int n, m;

    public static void main(String[] args) throws Exception {
        String str1 = br.readLine();
        String str2 = br.readLine();

        n = str1.length();
        m = str2.length();

        arr1 = new char[n+1];
        arr2 = new char[m+1];

        for (int i = 1 ; i <= n ; i ++) {
            arr1[i] = str1.charAt(i-1);
        }

        for (int i = 1 ; i <= m ; i ++) {
            arr2[i] = str2.charAt(i-1);
        }

        dp = new int[n+1][m+1];

        // input

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= m ; j ++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        while(n != 0 && m != 0) {

            if (dp[n][m] == dp[n-1][m]) {
                n--;
            } else if (dp[n][m] == dp[n][m-1]) {
                m--;
            } else {
                sb.append(arr1[n]);

                n--;
                m--;
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
        sb.reverse();
        System.out.println(sb);
    }

}