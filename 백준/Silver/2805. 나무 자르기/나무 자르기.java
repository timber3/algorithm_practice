import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, max;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0 ; i < n ; i ++) {
                if (arr[i] - mid > 0) {
                    sum += (arr[i] - mid);
                }
            }

            if (sum >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}