import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] arr, result;
    static int k;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        while(true) {

            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            arr = new int[k];

            for (int i = 0 ; i < k ; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[k];
            result = new int[6];

            dfs(0, 0);

            System.out.println(sb);
        }
    }

    static void dfs(int cur, int idx) {
        if (cur == 6) {
            for (int i = 0 ; i < 6 ; i ++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');

            return;
        }

        for (int i = idx ; i < k ; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cur] = arr[i];
                dfs(cur + 1, i);
                visited[i] = false;
            }
        }
    }
}