import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, start, result = Integer.MAX_VALUE;
    static int[][] Map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        Map = new int[n+1][n+1];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            visited = new boolean[n];
            start = i;
            visited[start] = true;
            dfs(start,0, 0);
        }

        System.out.println(result);
    }

    static void dfs(int cur, int cnt, int sum) {

        if (allVisited()) {
            if (Map[cur][start] != 0){
                result = Math.min(sum + Map[cur][start], result);
            }
            return;
        }

        for (int i = 0 ; i < n ; i++ ) {
            if(!visited[i] && Map[cur][i] != 0){
                visited[i] = true;
                dfs(i, cnt + 1, sum + Map[cur][i]);
                visited[i] = false;
            }
        }
    }

    static boolean allVisited() {
        for (int i = 0 ; i < n ; i ++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
