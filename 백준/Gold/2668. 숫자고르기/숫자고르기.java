import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, count;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        used = new boolean[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (!used[i]) {
                bfs(i);
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (used[i]) count ++;
        }
        sb.append(count).append('\n');

        for (int i = 1 ; i <= n ; i ++) {
            if (used[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int start) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.add(start);
        boolean find = false;

        while (!q.isEmpty()) {

            int cur = q.poll();

            int next = arr[cur];

            if (next == start) {
                visited[next] = true;
                find = true;
                break;
            }

            if (!used[next] && !visited[next]) {
                q.add(next);
                visited[next] = true;
            }
        }

        if (find) {
            for (int i = 1 ; i <= n ; i ++) {
                if(visited[i]) {
                    used[i] = true;
                }
            }
        }
    }
}