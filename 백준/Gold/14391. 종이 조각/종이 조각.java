import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, max = 0;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    // 각 칸에 대해 가로/세로 선택
    static void dfs(int x, int y) {
        if (x == n) {
            calc();
            return;
        }

        int nextX = x;
        int nextY = y + 1;
        if (nextY == m) {
            nextX++;
            nextY = 0;
        }

        // 가로 조각으로 선택
        visited[x][y] = true;
        dfs(nextX, nextY);

        // 세로 조각으로 선택
        visited[x][y] = false;
        dfs(nextX, nextY);
    }

    // 종이 조각 합계 계산
    static void calc() {
        int sum = 0;

        // 가로 조각 계산
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) { // 가로 조각
                    temp = temp * 10 + arr[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp; // 줄 끝나면 더하기
        }

        // 세로 조각 계산
        for (int j = 0; j < m; j++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i][j]) { // 세로 조각
                    temp = temp * 10 + arr[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp; // 줄 끝나면 더하기
        }

        max = Math.max(max, sum);
    }
}
