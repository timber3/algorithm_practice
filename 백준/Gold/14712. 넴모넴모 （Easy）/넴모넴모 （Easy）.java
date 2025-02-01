import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[][] map;
    static int n, m, count;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        dfs(0,0);

        System.out.println(count);
    }

    static void dfs(int x, int y) {

        if (x == n) {
            count ++;
            return;
        }

        int nx = x;
        int ny = y;

        if (y == m-1) {
            nx += 1;
            ny = 0;
        } else {
            ny += 1;
        }

        // 놓지 않고 넘어가기
        dfs(nx, ny);

        // 놓고 넘어가기
        if (canPut(x, y)) {
            map[x][y] = true;
            dfs(nx, ny);
            map[x][y] = false;
        }

    }

    static boolean canPut(int x, int y) {

        if (x >= 1 && y >= 1) {
            if (map[x-1][y] && map[x][y-1] && map[x-1][y-1]) return false;
        }

        return true;
    }
}