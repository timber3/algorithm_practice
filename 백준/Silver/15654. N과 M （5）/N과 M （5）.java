import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] result;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        result = new int[m];
        visited = new boolean[n+1];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int cur) {

        if (cur == m) {
            for (int i = 0; i < result.length ; i ++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cur] = arr[i];
                dfs(cur+1);
                visited[i] = false;
            }
        }
    }

}