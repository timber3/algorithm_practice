import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, oper;
    static int plus, minus, multiply, divide;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        oper = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        oper[0] = Integer.parseInt(st.nextToken());
        oper[1] = Integer.parseInt(st.nextToken());
        oper[2] = Integer.parseInt(st.nextToken());
        oper[3] = Integer.parseInt(st.nextToken());

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int val) {

        if (depth == n) {
            if (val > max) {
                max = val;
            }

            if (min > val) {
                min = val;
            }
            return;
        }

        for (int i = 0 ; i < 4 ; i ++) {
            if (oper[i] != 0) {
                oper[i]--;

                if (i == 0) {
                    dfs(depth + 1, val + arr[depth]);
                }
                if (i == 1) {
                    dfs(depth + 1, val - arr[depth]);
                }
                if (i == 2) {
                    dfs(depth + 1, val * arr[depth]);
                }
                if (i == 3) {
                    dfs(depth + 1, val / arr[depth]);
                }

                oper[i] ++;
            }
        }
    }
}