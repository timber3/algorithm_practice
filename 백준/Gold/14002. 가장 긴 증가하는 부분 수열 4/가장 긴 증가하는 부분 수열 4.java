import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static int n, maxLen, maxIdx;
    static int[] arr, dp, prev;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        dp = new int[n];
        prev = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            // 초기화
            dp[i] = 1;
            prev[i] = -1;
            
            // 처음부터 순회하면서 해당 값이 더 크고, dp + 1 한 값이 더 크면 갱신
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        sb.append(maxLen).append('\n');

        Stack<Integer> stack = new Stack<>();
        int cur = maxIdx;
        while (cur != -1) {
            stack.push(arr[cur]);
            cur = prev[cur];
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}