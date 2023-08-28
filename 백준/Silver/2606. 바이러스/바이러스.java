import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, e;
    static int Map[][];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        Map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            Map[from][to] = 1;
            Map[to][from] = 1;
        }

        bfs();

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                result ++;
        }

        System.out.println(result-1);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                if (Map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
