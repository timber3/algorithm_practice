import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m, min = Integer.MAX_VALUE;
    static char[][] map;
    static int[][] visited;
    static boolean[][] visited2;

    static int jx, jy;
    static ArrayList<Node> fire = new ArrayList<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

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

        visited = new int[n][m];
        visited2 = new boolean[n][m];
        map = new char[n][m];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'F') {
                    fire.add(new Node(i, j));
                }

                if (map[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }

        fire_bfs();
        jh_bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }
    }

    static void fire_bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        for (Node n : fire) {
            q.add(n);
            visited[n.x][n.y] = 0;
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == '#') continue;

                if (visited[nx][ny] != -1) continue;

                if (map[nx][ny] == '.' && visited[nx][ny] == -1) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
    }

    static class Node2 {
        int x;
        int y;
        int t;

        public Node2(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static void jh_bfs() {
        ArrayDeque<Node2> q = new ArrayDeque<>();
        q.add(new Node2(jx, jy, 0));
        visited2[jx][jy] = true;

        while(!q.isEmpty()) {
            Node2 cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int ct = cur.t;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 이 때는 탈출 했을 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    int nt = ct + 1;
                    if (min > nt) min = nt;
                    continue;
                }

                if (map[nx][ny] == '#') continue;

                if (map[nx][ny] == '.' && !visited2[nx][ny] && (visited[nx][ny] == -1 || visited[nx][ny] > ct + 1)) {
                    q.add(new Node2(nx, ny, ct+1));
                    visited2[nx][ny] = true;
                }
            }
        }
    }

}