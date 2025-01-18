import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, l, r, count, result;
    static int[][] map, visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    visited[i][j] = -1;
                }
            }
            count = 0;
            // l 이상 r 이하
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (visited[i][j] == -1) {
                        count ++;
                        bfs(i, j, count);
                    }
                }
            }

            // 국경을 안 열었다면
            if (count == n * n) {
                break;
            }

            result ++;
        }

        System.out.println(result);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int idx) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayList<Node> list = new ArrayList<>();
        q.add(new Node(x, y));
        visited[x][y] = idx;

        int sum = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            sum += map[cx][cy];
            list.add(new Node(cx, cy));

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != -1) continue;

                int sub = Math.abs(map[cx][cy] - map[nx][ny]);

                if ( sub >= l && sub <= r ) {
                    q.add(new Node(nx ,ny));
                    visited[nx][ny] = visited[cx][cy];
                }
            }
        }

        int average = sum / list.size();

        for (Node cur : list) {
            map[cur.x][cur.y] = average;
        }
    }
}
