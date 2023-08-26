import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    static int dx[] = { 0, 0, -1 ,1};
    static int dy[] = { 1, -1, 0 ,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] Map;
    static int[][] dist;
    static ArrayList<Node> tomatos;
    static int result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Map = new int[n][m];
        dist = new int[n][m];
        tomatos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i] , -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if ( Map[i][j] == 1) {
                    tomatos.add(new Node(i, j));
                }
            }
        }

        bfs();

        boolean can_go = true;

        for (int i = 0 ; i < n ; i++ ) {
            for (int j = 0; j < m; j++) {
                if (Map[i][j] != -1 && dist[i][j] == -1) {
                    can_go = false;
                    break;
                }

                if (dist[i][j] > result) {
                    result = dist[i][j];
                }
            }
        }

        if (can_go)
            System.out.println(result);
        else
            System.out.println(-1);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < tomatos.size(); i++) {
            Node temp = tomatos.get(i);
            q.add(temp);
            dist[temp.x][temp.y] = 0;
        }

        while(!q.isEmpty()) {

            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || dist[nx][ny] != -1) continue;

                if (Map[nx][ny] == -1 ) continue;  // 벽이면 못감

                if (Map[nx][ny] == 0) {
                    q.add(new Node(nx ,ny));
                    dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }
    }
}
