import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] Map;
    static boolean[] alpha;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static int r, c;
    static int Max;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Map = new char[r][c];
        alpha = new boolean[32];

        for (int i = 0 ; i < r ; i ++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                Map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(Max);
    }

    static void dfs(int x, int y, int dep) {

        int cx = x;
        int cy = y;
        alpha[Map[cx][cy] - 65] = true;

        for (int i = 0 ; i < 4; i ++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c || alpha[Map[nx][ny] - 65])
                continue;

            dfs(nx, ny, dep + 1);

            alpha[Map[nx][ny] - 65] = false;
        }
        Max = Math.max(Max, dep);
    }
}
