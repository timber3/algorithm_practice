import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int[] used;
    static int n, k, max;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        used = new int[100001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while(left < n && right < n) {
            if (used[arr[right]] < k) {
                used[arr[right]] += 1;
                right ++;
                count ++;
            } else {
                used[arr[left]] -= 1;
                left ++;
                count --;
            }

            if (count > max) max = count;
        }

        System.out.println(max);
    }
}