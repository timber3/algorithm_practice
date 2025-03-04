import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;

    static int n, m, min = Integer.MAX_VALUE, resultX, resultY;
    static int[] chicken;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        chicken = new int[2];

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                arr[i][j] = Integer.MAX_VALUE;
                if (i == j) arr[i][j] = 0;
            }
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        floyd();

        dfs(0, 1);

        System.out.println(resultX + " " + resultY + " " + min * 2);

    }

    static void floyd() {
        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE) continue;
                    if (arr[i][j] > arr[i][k] + arr[j][k]) {
                        arr[i][j] = arr[i][k] + arr[j][k];
                    }
                }
            }
        }
    }

    static void dfs(int depth, int idx) {
        if (depth == 2) {
            int sum = 0;
            int x = -1;
            int y = -1;

            for (int i = 1 ; i <= n ; i ++) {
                // 치킨집 사이의 거리가 짧은것을 선택해서 합연산 하기
                sum += Math.min(arr[i][chicken[0]], arr[i][chicken[1]]);
            }

            if (min > sum) {
                resultX = chicken[0];
                resultY = chicken[1];
                min = sum;
            }

            return;
        }

        for (int i = idx ; i <= n ; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                chicken[depth] = i;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
