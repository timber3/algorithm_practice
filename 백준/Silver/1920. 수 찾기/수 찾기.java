import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] a, b;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        a = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        b = new int[m];

        for (int i = 0 ; i < m ; i ++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        // input

        Arrays.sort(a);

        solve();

        System.out.println(sb);
    }

    static void solve() {
        // 모든 b 들을 전부 해야함.
        for (int i = 0 ; i < b.length ; i ++) {

            int target = b[i];
            int left = 0;
            int right = a.length - 1;
            boolean found = false;

            while(left <= right) {
                int mid = (left + right) / 2;
                if (a[mid] == target) {
                    sb.append("1\n");
                    found = true;
                    break;
                }

                if (a[mid] > target) {
                    right = mid - 1;
                }

                if (a[mid] < target) {
                    left = mid + 1;
                }
            }

            if (!found) sb.append("0\n");

        }
    }
}