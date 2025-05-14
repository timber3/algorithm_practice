import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, result = 0;
    static int[] origin, arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        origin = new int[n];
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0 ; i < n ; i ++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int depth, int idx) {

        if (depth == n) {
            // 계산 후 갱신
            int sum = 0;
            for (int i = 0 ; i < n-1 ; i ++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            if (sum > result) result = sum;
            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = origin[i];
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }

}