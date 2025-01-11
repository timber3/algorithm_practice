import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] map;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            map = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);
        }
        br.close();
    }

    static void dfs(int current) {
        visited[current] = true;
        int next = map[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != current; i = map[i]) {
                count++;
            }
            count++;
        }
        finished[current] = true;
    }
}