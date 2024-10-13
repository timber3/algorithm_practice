import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        visited = new boolean[n+1];

        dfs(0);
    }

    static void dfs(int cur) {

        if (cur == m) {
            for (int i = 0; i < result.length ; i ++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (!visited[i]) {
                result[cur] = i;
                visited[i] = true;
                dfs(cur + 1);
                visited[i] = false;
            }
        }
    }

}