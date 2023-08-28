import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        int h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] Map, visited;

    static ArrayList<Node> tomatos;
    static int n, m, h;
    static int dx[] = {0,0,-1,1,0,0};
    static int dy[] = {1,-1,0,0,0,0};
    static int dh[] = {0,0,0,0,1,-1};
    static int result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        Map = new int[h][n][m];
        visited = new int[h][n][m];
        tomatos = new ArrayList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[k][i][j] = -1;
                }
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    Map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (Map[k][i][j] == 1) {
                        tomatos.add(new Node(i,j,k));
                    }
                }
            }
        }

        bfs();

        boolean can_go = true;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 벽이 아닌데 visited 가 -1 이면 못함
                    if (visited[k][i][j] == -1 && Map[k][i][j] != -1)
                    {
                        System.out.println(-1);
                        return;
                    }

                    if (visited[k][i][j] > result) {
                        result = visited[k][i][j];
                    }
                }
            }
        }

        System.out.println(result);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < tomatos.size(); i++) {
            Node temp = tomatos.get(i);
            q.add(tomatos.get(i));
            visited[temp.h][temp.x][temp.y] = 0;
        }

        while (!q.isEmpty()) {

            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int ch = cur.h;

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nh = ch + dh[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || nh < 0 || nh >= h)
                    continue;

                // 이미 방문을 했던 곳이거나, 지도상으로 빈공간일 경우
                if (visited[nh][nx][ny] != -1 || Map[nh][nx][ny] == -1) {
                    continue;
                }

                q.add(new Node(nx, ny, nh));
                visited[nh][nx][ny] = visited[ch][cx][cy] + 1;
            }
        }
    }
}
