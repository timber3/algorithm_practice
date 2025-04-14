import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static int n, m, result, max;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0 ; i < n ; i ++) {
                if (arr[i] < mid) {
                    sum += arr[i];
                } else {
                    sum += mid;
                }
            }

            // 합계가 m보다 작으면 더 늘릴 수 있음
            if (sum <= m) {
                result = mid;
                left = mid + 1;
            }
            // 합계가 m보다 크면 줄여야 함.
            else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}