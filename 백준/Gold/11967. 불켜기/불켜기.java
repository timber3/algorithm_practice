import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, count = 1;
    static boolean[][] map;
    static ArrayList<Node>[][] swch;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node {
        int x, y;
        public Node (int x, int y) {
            this.x=x; this.y= y;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 불 켜져있는지 확인용
        map = new boolean[n][n];
        // 각 맵에 있는 스위치
        swch = new ArrayList[n][n];
        visited = new boolean[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                swch[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            swch[x][y].add(new Node(a, b));
        }

        bfs();

        System.out.println(count);

        // 스위치를 켜면 주변에 visited 가 있는지 확인하기  => visited 가 있다면 방문한 곳과 연결되었다는 뜻
        // visited 가 없으면 그냥 불만 켜져있는 상태
        // 불은 켜져있는데 visited 가 없으면 그쪽으로 bfs 진행
    }

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0));
        map[0][0] = true;
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            // 방의 스위치를 전부 켜고 갈 수 있는 곳이 있다면 q에 넣어주기
            for (Node sw : swch[cx][cy]) {
                // 불이 안켜져 있으면 켜면서 갈 수 있는지 확인하기
                if (!map[sw.x][sw.y]) {
                    map[sw.x][sw.y] = true;
                    count ++;

                    if (canGo(sw.x, sw.y)) {
                        visited[sw.x][sw.y] = true;
                        q.add(new Node(sw.x, sw.y));
                    }
                }
            }

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어나거나, 방문한 적이 있거나, 불이 꺼져있다면 가지 않는다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || !map[nx][ny]) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static boolean canGo(int x, int y) {
        for (int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;

            if (visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }
}