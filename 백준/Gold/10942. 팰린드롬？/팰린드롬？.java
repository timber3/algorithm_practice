import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (pallin(s,e)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }

    static boolean pallin(int from, int to) {

        int count = to - from;

        // 짝수개 배열
        if (count % 2 == 1) {
            for (int i = 0 ; i < count/2 + 1 ; i ++) {
                if (arr[from + i] != arr[to - i]) {
                    return false;
                }
            }
        }
        // 홀수개 배열
        else {
            for (int i = 0 ; i < count - 1 ; i ++) {
                if (arr[from + i] != arr[to - i]) {
                    return false;
                }
            }
        }
        return true;
    }

}