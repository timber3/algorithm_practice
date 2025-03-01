import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0 ; i < n ; i ++) {
                sb.append(arr[i] + 1 + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
