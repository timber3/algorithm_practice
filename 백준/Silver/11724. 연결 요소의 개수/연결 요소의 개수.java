import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, result;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (!visited[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void bfs(int x) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {

            int cur = q.poll();

            for (int i = 1 ; i <= n ; i ++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}