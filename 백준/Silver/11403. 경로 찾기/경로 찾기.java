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

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            bfs(i);
        }

        for (int i = 0; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited = new boolean[n];
        q.add(x);

        while(!q.isEmpty()) {

            int cur = q.poll();

            for (int i = 0 ; i < n ; i ++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    map[x][i] = 1;
                    visited[i] = true;
                }
            }
        }
    }

}