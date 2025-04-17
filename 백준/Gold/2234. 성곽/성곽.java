//11:05

import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, maxWidth, deleteMax, count = 1;
    static int[][][] wall;
    static int[][] map;
    static int[][] visited;

    // 1:서 2:북 4:동 8:남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

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

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        wall = new int[n][m][4];
        map = new int[n][m];
        visited = new int[n][m];

        // 벽에 대한 정보는 다 담아둠.
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < m ; j ++) {
                int v = Integer.parseInt(st.nextToken());

                for (int k = 0 ; k < 4 ; k ++) {
                    int bit = (v >> k) & 1;
                    wall[i][j][k] = bit;
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j ++) {

                // 방문한 적 없는 땅이라면
                if (visited[i][j] == 0) {
                    int width = bfs(i, j);
                    count ++;
                    if (width > maxWidth) maxWidth = width;
                }
            }
        }

        // 하나의 벽을 제거하고 얻을 수 있는 가장 넓은 방
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                for (int k = 0 ; k < 4 ; k ++) {

                    // 벽아니면 넘어가기
                    if (wall[i][j][k] == 0) continue;

                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 벽을 제거했을 때 범위를 넘어가는 곳으로 제거하면 안됨
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    // visited 초기화
                    for (int t = 0 ; t < n ; t ++) {
                        Arrays.fill(visited[t], 0);
                    }

                    // 벽 삭제
                    wall[i][j][k] = 0;
                    int width = bfs(i, j);
                    if (width > deleteMax) deleteMax = width;
                    wall[i][j][k] = 1;
                }
            }
        }

        System.out.println(count-1);
        System.out.println(maxWidth);
        System.out.println(deleteMax);

    }

    static int bfs(int x, int y) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[x][y] = count;
        q.add(new Node(x, y));
        int width = 0;

        while(!q.isEmpty()) {

            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            width ++;

            for (int i = 0 ; i < 4 ; i ++) {
                // 해당 방향으로 벽이 있다면
                if (wall[cx][cy][i] == 1) continue;

                // 벽이 없으면
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어나지는 않겠지만 범위를 벗어난다면
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 이미 방문한 곳이라면
                if (visited[nx][ny] != 0) continue;

                q.add(new Node(nx, ny));
                visited[nx][ny] = count;
            }
        }

        return width;
    }
}