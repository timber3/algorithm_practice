import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][k+1];

        for (int i = 0 ; i < n ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                for (int t = 0 ; t <= k ; t ++) {
                    visited[i][j][t] = -1;
                }
            }
        }

        bfs();

        for(int i = 0 ; i <= k ; i++) {
            if (visited[n-1][m-1][i] != -1 && min > visited[n-1][m-1][i]) {
                min = visited[n-1][m-1][i];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;
            int cc = cur.crush;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny][cc] != -1) continue;

                // 다음 갈 곳이 벽이면서, 이미 가본 적 없는 곳이며, 뚫을 수 있는 기회가 남아있다면
                if (map[nx][ny] == 1 && cc < k && visited[nx][ny][cc+1] == -1 ) {
                    q.add(new Node(nx, ny, cc + 1));
                    visited[nx][ny][cc+1] = visited[cx][cy][cc] + 1;
                }

                // 벽을 안 부수고 넘어가기
                if (map[nx][ny] == 0) {
                    visited[nx][ny][cc] = visited[cx][cy][cc] + 1;
                    q.add(new Node(nx, ny, cc));
                }
            }
        }
    }

}