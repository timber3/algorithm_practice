import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int n, m, k, count;
    static int[][] map, visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            count = 0;
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new int[n][m];

            for (int i = 0 ; i < n ; i ++ ) {
                for (int j = 0 ; j < m ; j ++) {
                    visited[i][j] = -1;
                }
            }

            for (int i = 0 ; i < k ; i ++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < m ; j ++) {
                    if (visited[i][j] == -1 && map[i][j] == 1) {
                        count ++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        ArrayDeque<Node> q = new ArrayDeque<Node>();
        q.add(new Node(x, y));
        visited[x][y] = count;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 이미 방문을 한 곳이거나 배추가 아니면 continue
                if (visited[nx][ny] != -1 || map[nx][ny] == 0) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = count;
            }
        }

    }

}