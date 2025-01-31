import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, no = 1, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] visited, visitedCopy;
    static boolean[][] border;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new int[n][n];
        border = new boolean[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (map[i][j] == 1 && visited[i][j] == -1) {
                    floodFill(i, j);
                    no ++;
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j ++) {
                if (border[i][j]) {
                    min = Math.min(min, findAnotherLand(i, j));
                }
            }
        }

        System.out.println(min);
    }

    static class Node {
        int x;
        int y;
        int dis;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static void floodFill(int x, int y) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[x][y] = no;
        q.add(new Node(x, y));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != -1) continue;

                // 다음 갈 곳이 0이라면 경계 구간임
                if (map[nx][ny] == 0) {
                    border[cx][cy] = true;
                }

                // 1이면 floodFill
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = no;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    static int findAnotherLand(int x, int y) {
        int curNo = visited[x][y];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, 0));

        visitedCopy = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                visitedCopy[i][j] = visited[i][j];
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cd = cur.dis;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 다음 갈 곳이 육지라면 해당 육지가 curNo랑 다른곳만 갈 수 있음 (같으면 가면 안됨)
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visitedCopy[nx][ny] == curNo) continue;

                // 다음 갈 곳이 바다라면 그냥 나가면 됨
                if (visitedCopy[nx][ny] == -1) {
                    visitedCopy[nx][ny] = 0;
                    q.add(new Node(nx, ny, cd + 1));
                }

                if (visitedCopy[nx][ny] != 0 && visitedCopy[nx][ny] != -1)
                    return cd;
            }
        }

        return Integer.MAX_VALUE;
    }
}