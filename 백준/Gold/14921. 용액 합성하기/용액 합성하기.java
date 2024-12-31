import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < Math.abs(result)) result = sum;

            if (sum > 0) {
                right --;
            } else if (sum < 0) {
                left ++;
            } else {
                // 0인 경우
                break;
            }
        }

        System.out.println(result);
    }
}