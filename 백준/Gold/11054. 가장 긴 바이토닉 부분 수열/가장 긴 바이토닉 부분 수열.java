import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, result = 0;
    static int[] arr;
    static int[] dp1;
    static int[] dp2;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 순열 구하기
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < i ; j ++) {
                if (arr[i] > arr[j] && dp1[i] <= dp1[j]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        // 뒤에서 부터 오름차순 구하기
        for (int i = n-1 ; i >= 0 ; i --) {
            for (int j = n-1 ; j > i ; j --) {
                if (arr[i] > arr[j] && dp2[i] <= dp2[j]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            result = Math.max(dp1[i] + dp2[i] -1, result);
        }

        System.out.println(result);
    }
}