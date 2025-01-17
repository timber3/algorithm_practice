import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, min = Integer.MAX_VALUE, zero;
    static int[][] map, visited;
    static ArrayList<Node> avail = new ArrayList<>();
    static boolean[] selected;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 0: 빈칸   1: 벽   2: 바이러스를 놓을 수 있는 칸
                if (map[i][j] == 0) {
                    zero ++;
                }
                if (map[i][j] == 2) {
                    zero ++;
                    avail.add(new Node(i,j));
                }
            }
        }

        selected = new boolean[avail.size()];

        dfs(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    static void dfs(int depth, int idx) {

        if (depth == m) {
            int result = bfs();

            if (min > result) {
                min = result;
            }

            return;
        }

        for (int i = idx; i < avail.size() ; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(depth + 1, i);
                selected[i] = false;
            }
        }
    }

    static int bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        int zeroCount = 0;

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0 ; i < avail.size() ; i++) {
            if (selected[i]) {
                Node cur = avail.get(i);
                q.add(new Node(cur.x, cur.y));
                visited[cur.x][cur.y] = 0;
                zeroCount ++;
            }
        }

        int max = 0;

        while(!q.isEmpty()) {

            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            if (visited[cx][cy] > max) {
                max = visited[cx][cy];
            }

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1 || visited[nx][ny] != -1) continue;

                q.add(new Node(nx ,ny));
                visited[nx][ny] = visited[cx][cy] + 1;
                zeroCount ++;
            }
        }

        if (zeroCount == zero) {
            return max;
        } else {
            return Integer.MAX_VALUE;
        }
    }

}