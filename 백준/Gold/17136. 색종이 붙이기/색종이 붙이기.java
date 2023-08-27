import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] Map = new int[10][10];
    static int[] papers = new int[] {5, 5, 5, 5, 5};  // 색종이 5개씩 있음
    static int result = Integer.MAX_VALUE;
    static int blank;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if (Map[i][j] == 1 ) blank++;
            }
        }
        dfs(0, 0);
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }
    static void dfs(int cnt, int idx) {

        // 현재까지의 최소 갯수보다 많으면 되돌아가서 다른 방법 찾기
        if (cnt > result) return;

        if (blank == 0) {
            // 빈 공간이 없다면 최솟값 갱신해주기
            result = Math.min(result, cnt);
            return;
        }

        // 일단 주구장창 맵 전부를 확인한다.
        for (int i = idx; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // 1을 찾았으면 색종이를 붙여야 함.
                if (Map[i][j] == 1) {

                    // 1x1 부터 5x5 크기 까지 전부 다 대봄.
                    for (int k = 0; k < 5; k++) {
                        // 해당 크기의 종이를 다 썼다면 다른 종이로 붙이기
                        if (papers[k] == 0) continue;
                        // 만약 붙일 수 있으면 붙이기
                        if (isSquare(i, j, k)) {
                            int[][] copyMap = new int[10][10];

                            for (int a = 0; a < 10; a++) {
                                for (int b = 0; b < 10; b++) {
                                    copyMap[a][b] = Map[a][b];
                                }
                            }
                            // 색종이 붙이기 전에 맵 복사해놓기
                            stickPaper(i, j, k);
                            blank -= Math.pow(k+1, 2);
                            papers[k]--;
                            dfs(cnt + 1, i);
                            blank += Math.pow(k+1, 2);
                            papers[k]++;

                            // 다시 맵 복구시키기
                            for (int a = 0; a < 10; a++) {
                                for (int b = 0; b < 10; b++) {
                                    Map[a][b] = copyMap[a][b];
                                }
                            }
                        }
                    } return;
                }
            }
        }
    }

    static boolean isSquare(int x, int y, int size) {

        int nx = x + size;
        int ny = y + size;

        if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) return false;

        for (int i = x; i <= nx; i++) {
            for (int j = y; j <= ny; j++) {
                if (Map[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    static void stickPaper(int x, int y, int size) {
        for (int i = x; i <= x + size; i++) {
            for (int j = y; j <= y + size; j++) {
                Map[i][j] = 0;
            }
        }
    }
}