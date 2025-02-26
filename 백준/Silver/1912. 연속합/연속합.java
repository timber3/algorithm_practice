import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max = Integer.MIN_VALUE;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o2 - o1;
            }
    );
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        pq.add(dp[0]);

        for (int i = 1 ; i < n ; i ++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            pq.add(dp[i]);
        }

        System.out.println(pq.poll());
    }
}
