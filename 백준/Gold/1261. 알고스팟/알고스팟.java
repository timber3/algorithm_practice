import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j ++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(visited[n-1][m-1]);

    }

    static class Node {
        int x;
        int y;
        int crush;

        public Node(int x, int y, int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }
    }


    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1.crush - o2.crush;
                }
        );

        visited[0][0] = 0;

        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cc = cur.crush;

            for (int i = 0; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] != -1) continue;

                // 다음 갈 곳이 벽인데 가본 적 없는 곳이라면
                if (map[nx][ny] == 1) {
                    pq.add(new Node(nx, ny, cc + 1));
                    visited[nx][ny] = cc + 1;
                }

                // 다음 갈 곳이 벽이 아니라면
                if (map[nx][ny] == 0) {
                    pq.add(new Node(nx, ny, cc));
                    visited[nx][ny] = cc;
                }
            }
        }
    }
}
