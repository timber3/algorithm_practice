import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m, cnt, max;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    cnt ++;
                    bfs(i, j);
                }
            }
        }

        System.out.printf("%d\n%d", cnt, max);
    }

    static void bfs(int x, int y) {
        int max_Cnt = 1;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 1 || map[nx][ny] == 0)
                    continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = 1;
                max_Cnt ++;
            }
        }

        max = Math.max(max_Cnt, max);

    }

    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}