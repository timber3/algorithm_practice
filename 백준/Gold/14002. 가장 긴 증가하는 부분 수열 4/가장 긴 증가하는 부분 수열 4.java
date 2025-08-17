import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, index , max = 0;
    static int[] arr, dp, pre;
    static Stack<Integer> trace = new Stack<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        pre = new int [N];
        Arrays.fill(pre,-1);
        dp = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i < N ;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=1 ; i < N ; i++) {
            for(int j=i-1 ; j >=0 ; j--) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] +1;
                    pre[i] = j;
                }
            }
        }
        for(int i=0;i < N ;i++) {
            if(max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        sb.append(max+1).append("\n");
        while(index != -1) {
            trace.add(arr[index]);
            index = pre[index];
        }
        while(!trace.isEmpty()) {
            sb.append(trace.pop()).append(" ");
        }
        System.out.print(sb);
    }
}