import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, operator;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < 4 ; i ++ ){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr[0]);

        System.out.println(sb.append(max).append('\n').append(min));
    }

    static void dfs(int depth, int sum) {
        if (depth == n-1) {
            if (sum > max) max = sum;

            if (min > sum) min = sum;
            return;
        }

        if (operator[0] != 0) {
            operator[0] --;
            dfs(depth + 1, sum + arr[depth+1]);
            operator[0] ++;
        }

        if (operator[1] != 0) {
            operator[1] --;
            dfs(depth + 1, sum - arr[depth+1]);
            operator[1] ++;
        }

        if (operator[2] != 0) {
            operator[2] --;
            dfs(depth + 1, sum * arr[depth+1]);
            operator[2] ++;
        }

        if (operator[3] != 0) {
            operator[3] --;
            dfs(depth + 1, sum / arr[depth+1]);
            operator[3] ++;
        }
    }

}
