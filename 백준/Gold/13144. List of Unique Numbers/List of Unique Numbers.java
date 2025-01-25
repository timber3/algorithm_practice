// 85.4
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long count;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        used = new boolean[100_001];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        while (right < n) {
            if (!used[arr[right]]) {
                used[arr[right]] = true;
                right++;
                count += right - left;
            } else {
                used[arr[left]] = false;
                left++;
            }
        }

        System.out.println(count);
    }
}