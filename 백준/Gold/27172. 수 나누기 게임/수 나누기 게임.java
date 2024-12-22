import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, MAX = Integer.MIN_VALUE;
    static boolean[] exist;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        exist = new boolean[1_000_001];
        arr = new int[n+1];
        result = new int[1_000_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i ++) {
            int val = Integer.parseInt(st.nextToken());

            exist[val] = true;
            arr[i] = val;

            if (val > MAX) {
                MAX = val;
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            int idx = 1;
            while(true) {
                if (arr[i] * idx <= MAX) {
                    if (exist[arr[i] * idx]) {
                        result[arr[i]] ++;
                        result[arr[i] * idx] --;
                    }
                    idx++;
                } else {
                    break;
                }
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            sb.append(result[arr[i]]).append(" ");
        }

        System.out.println(sb);
    }
}