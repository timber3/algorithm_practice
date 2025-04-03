import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int robotX, robotY, robotD, desX, desY, desD;
    static int[][] map;
    static int[][][] visited;

    // 동 남 서 북 방향으로 재배치
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dd = {-1, 1};


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][4];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                for (int d = 0 ; d < 4 ; d ++) {
                    visited[i][j][d] = -1;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        robotX = Integer.parseInt(st.nextToken()) - 1;
        robotY = Integer.parseInt(st.nextToken()) - 1;
        robotD = Integer.parseInt(st.nextToken()) - 1;

        // 동 서 남 북
        // 동 남 서 북
        if (robotD == 1) robotD = 2;
        else if (robotD == 2) robotD = 1;

        st = new StringTokenizer(br.readLine());

        desX = Integer.parseInt(st.nextToken()) - 1;
        desY = Integer.parseInt(st.nextToken()) - 1;
        desD = Integer.parseInt(st.nextToken()) - 1;

        if (desD == 1) desD = 2;
        else if (desD == 2) desD = 1;

        bfs();

        System.out.println(visited[desX][desY][desD]);
    }

    static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[robotX][robotY][robotD] = 0;
        q.add(new Node(robotX,robotY,robotD));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;
            int cd = cur.d;

            if (cx == desX && cy == desY && cd == desD) return;

            // 제자리에서 방향돌리기 (left or right)
            for (int i = 0 ; i < 2 ; i ++) {
                int nd = (cd + dd[i]) % 4;
                if (nd == -1) nd = 3;
                if (visited[cx][cy][nd] == -1) {
                    q.add(new Node(cx, cy, nd));
                    visited[cx][cy][nd] = visited[cx][cy][cd] + 1;
                }
            }

            // 앞으로 가기
            loop: for (int i = 1 ; i <= 3 ; i ++) {
                int nx = cx + dx[cd] * i;
                int ny = cy + dy[cd] * i;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1) continue;

                if (visited[nx][ny][cd] != -1) continue;

                if (i >= 2) {
                    // 2칸, 3칸 앞으로 가는데 그 사이에 벽이 있으면 못감
                    for (int j = 1 ; j <= i ; j++) {
                        if (map[nx - dx[cd] * j][ny - dy[cd] * j] == 1) continue loop;
                    }
                }

                q.add(new Node(nx, ny, cd));
                visited[nx][ny][cd] = visited[cx][cy][cd] + 1;
            }
        }
    }

}
