import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;

    static int n, diff = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        arr = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(diff);
    }

    static void dfs(int depth) {
        if (depth == n) {
            boolean keep = false;

            for (int i = 0 ; i < n ; i ++) {
                if (visited[i]) {
                    keep = true;
                }
            }

            if (keep) {
                int sumStart = 0;
                int sumLink = 0;

                for (int i = 0 ; i < n ; i ++) {
                    for (int j = 0 ; j < n ; j ++) {
                        if (visited[i] && visited[j]) sumStart += arr[i][j];
                        else if (!visited[i] && !visited[j]) sumLink += arr[i][j];
                    }
                }

                int dif = Math.abs(sumStart - sumLink);
                if (diff > dif) diff = dif;

            }

            return;
        }

        // 팀으로 선택하고 다음
        visited[depth] = true;
        dfs(depth + 1);
        visited[depth] = false;

        // 팀으로 선택 안하고 다음
        dfs(depth + 1);


    }
}
