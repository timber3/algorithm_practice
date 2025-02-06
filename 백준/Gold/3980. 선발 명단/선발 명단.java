import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, max;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            map = new int[11][11];
            visited = new boolean[11];
            max = 0;

            for (int i = 0 ; i < 11 ; i ++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < 11 ; j ++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);

            System.out.println(max);
        }
    }

    static void dfs(int depth, int sum) {
        if (depth == 11) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        if (sum + (11 - depth) * 100 <= max)
            return;

        for (int i = 0 ; i < 11; i ++) {
            if (map[depth][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + map[depth][i]);
                visited[i] = false;
            }
        }
    }
}