import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        long sum = 0;
        int count = 0;

        while(right <= n && left < n) {
            if (sum == m) {
                count ++;
                sum -= arr[left++];
            } else if (right < n && sum < m) {
                sum += arr[right++];
            } else {
                sum -= arr[left++];
            }
        }

        System.out.println(count);

    }
}