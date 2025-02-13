import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, max = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        // n 필요한 랜선의 개수
        // k 이미 갖고있는 랜선의 개수

        for (int i = 0 ; i < k ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }

        long result = 0;
        long left = 1;
        long right = max;

        while(left <= right) {
            long mid = (left + right) / 2;
            int count = 0;

            for (int i = 0 ; i < k ; i ++) {
                count += (arr[i] / mid);
            }

            if (count >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}