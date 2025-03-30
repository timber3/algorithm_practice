import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int n, m;
    static boolean find;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(0, i, j, -1, -1);
                    if(find) {
                        System.out.println("Yes");
                        return;
                    }

                }
            }
        }

        System.out.println("No");
    }

    static class Node {
        int x, y, count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int depth, int x, int y, int bx, int by) {

        if (find) return;

        for (int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            // 다음갈 곳이 방문했는데, 내가 왔던 곳에서 가는게 아니라면? (0,0) -> (0,1) -> (0,0) 이 경우가 아니라면?
            if (visited[nx][ny] && map[x][y] == map[nx][ny] && (nx != bx || ny != by)) {
                find = true;
                return;
            }

            if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                visited[nx][ny] = true;
                dfs(depth + 1, x + dx[i], y + dy[i], x, y);
            }
        }

    }
}
