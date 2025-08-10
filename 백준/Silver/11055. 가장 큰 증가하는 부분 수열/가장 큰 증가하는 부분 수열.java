import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i <= N ;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }
        max= dp[N];
        for(int i=N  ; i >=1 ; i--) {
            for(int j = i -1; j >=1 ; j--) {
                if(arr[i] > arr[j]) {
                    dp[j] = Math.max(dp[j] , dp[i] + arr[j]);
                }
            }
            max = Math.max(max,dp[i]);

        }
        System.out.print(max);
    }
}