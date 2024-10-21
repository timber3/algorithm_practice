import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, result;
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new int[n+1];

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }

        bfs();

        System.out.println(result);
    }

    public static void bfs() {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 1;

        while(!q.isEmpty()) {

            int cur = q.poll();

            for (int i = 1 ; i <= n ; i ++) {
                if (map[cur][i] == 1 && visited[i] == 0) {
                    q.add(i);
                    visited[i] = visited[cur] + 1;
                    if (visited[i] <= 3) result++;
                }
            }
        }
    }

}