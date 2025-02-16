import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, result;
    static int[][] map, visited;
    static ArrayList<Integer> list = new ArrayList<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0 ; i < k ; i ++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int X = x1 ; X < x2 ; X ++) {
                for (int Y = y1 ; Y < y2 ; Y ++) {
                    map[X][Y] = 1;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (visited[i][j] == 0 && map[i][j] == 0) {
                    result ++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);

        sb.append(result).append('\n');

        for (int v : list) {
            sb.append(v).append(' ');
        }

        System.out.println(sb);
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
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[x][y] = result;
        q.add(new Node(x, y));
        int count = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            count ++;

            for (int i = 0 ; i < 4; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (visited[nx][ny] != 0 || map[nx][ny] == 1) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = result;
            }
        }

        list.add(count);
    }
}