import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m, min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1;

        while(left < n && right < n) {
            int sub = arr[right] - arr[left];

            if (sub >= m && min > sub) {
                min = sub;
            }

            if (sub > m) {
                left ++;
            } else {
                right ++;
            }

            if (min == m) break;
        }
        System.out.println(min);
    }
}