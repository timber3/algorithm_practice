import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, len;
    static int[] arr, poly, dp;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        int val = 1;
        int count = 2;

        while(true) {
            if (val > n) break;
            list.add(val);
            val += count++;
        }

        len = list.size();
        arr = new int[len];
        poly = new int[len];

        for (int i = 0 ; i < len ; i ++) {
            arr[i] = list.get(i);
        }

        poly[0] = 1;
        
        if (len >= 2) {
            poly[1] = 4;
            for (int i = 2 ; i < len ; i ++) {
                poly[i] = poly[i-1] + arr[i];
            }
        }

        dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // 모든 피라미드 개수만큼
        for (int i = 0; i < len; i++) {
            int current = poly[i];

            for (int j = current; j <= n; j++) {
                if (dp[j - current] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - current] + 1);
                }
            }
        }

        System.out.println(dp[n]);

    }
}