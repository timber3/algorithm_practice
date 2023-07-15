import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pipe {
    int status;
    int x;
    int y;

    pipe(int x, int y, int st){
        this.x = x;
        this.y = y;
        this.status = st;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] Map;
    static int count = 0;

    static void dfs(pipe p) {

        // 종료조건
        if (p.x == n-1 && p.y == n-1) {
            count++;
            return;
        }

        // p.status
        // 0 = 가로 1 = 세로 2 = 대각선

        // 가로
        if (p.status == 0) {
            // 가로로 갈 수 있으면
            if (p.y + 1 < n && Map[p.x][p.y+1] != 1) {
                dfs(new pipe(p.x, p.y+1,0));
            }
            // 대각선으로 갈 수 있으면
            if (p.x + 1 < n && p.y + 1 < n && (Map[p.x][p.y + 1] + Map[p.x + 1][p.y] + Map[p.x + 1][p.y + 1]) == 0) {
                dfs(new pipe(p.x+1, p.y+1, 2));
            }
        }

        // 세로
        if (p.status == 1) {
            // 세로로 갈 수 있으면
            if (p.x + 1 < n && Map[p.x+1][p.y] != 1) {
                dfs(new pipe(p.x+1,p.y,1));
            }
            // 대각선으로 갈 수 있으면
            if (p.x + 1 < n && p.y + 1 < n && (Map[p.x][p.y + 1] + Map[p.x + 1][p.y] + Map[p.x + 1][p.y + 1]) == 0) {
                dfs(new pipe(p.x+1, p.y+1, 2));
            }
        }

        // 대각선
        if (p.status == 2) {

            // 가로로 갈 수 있으면
            if (p.y + 1 < n && Map[p.x][p.y+1] != 1) {
                dfs(new pipe(p.x, p.y+1,0));
            }

            // 세로로 갈 수 있으면
            if (p.x + 1 < n && Map[p.x+1][p.y] != 1) {
                dfs(new pipe(p.x+1,p.y,1));
            }

            // 대각선으로 갈 수 있으면
            if (p.x + 1 < n && p.y + 1 < n && (Map[p.x][p.y + 1] + Map[p.x + 1][p.y] + Map[p.x + 1][p.y + 1]) == 0) {
                dfs(new pipe(p.x+1, p.y+1, 2));
            }
        }

        return;
    }

    public static void main(String[] args) throws IOException{

        n = Integer.parseInt(br.readLine());
        Map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new pipe(0,1,0));

        System.out.println(count);

    }
}
