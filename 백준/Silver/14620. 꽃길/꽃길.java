import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 1);

        System.out.println(min);
    }

    static void dfs(int depth, int x, int y) {
        if (depth == 3) {
            int sum = 0;

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (visited[i][j]) {
                        sum += map[i][j];
                    }
                }
            }

            if (min > sum) min = sum;

            return;
        }

        for (int i = x ; i < n-1 ; i ++) {
            for (int j = (i == x) ? y : 0 ; j < n-1 ; j ++) {
                if (canPlant(i, j) && !visited[i][j]) {

                    visited[i][j] = true;
                    for (int k = 0 ; k < 4 ; k ++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        visited[nx][ny] = true;
                    }

                    dfs(depth + 1, i, j);

                    visited[i][j] = false;
                    for (int k = 0 ; k < 4 ; k ++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    static boolean canPlant(int cx, int cy) {
        for (int i = 0 ; i < 4; i ++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n ) return false;

            if (visited[nx][ny]) return false;
        }

        return true;
    }

}