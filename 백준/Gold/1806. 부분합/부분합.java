import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, s, result = 99999;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int from = 0;
        int to = 0;
        long sum = 0;

        while(from < n && to < n) {
            sum += arr[to];

            while (sum >= s) {
                // 최소값 갱신
                if (result > to - from + 1) {
                    result = to - from + 1;
                }
                sum -= arr[from++];
            }
            to ++;
        }

        if (result == 99999) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}