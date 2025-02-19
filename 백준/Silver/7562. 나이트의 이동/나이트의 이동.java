import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int n;

    static int[][] map;
    static int[][] visited;
    static int sx, sy, ex, ey;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new int[n][n];

            st = new StringTokenizer(br.readLine());

            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(visited[ex][ey]);
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                visited[i][j] = -1;
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[sx][sy] = 0;
        q.add(new Node(sx, sy));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 8 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != -1) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = visited[cx][cy] + 1;
            }
        }
    }
}