import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] map, dp;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {

        if (x == n-1 && y == m-1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;

            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx,ny);
            }
        }

        return dp[x][y];
    }
}