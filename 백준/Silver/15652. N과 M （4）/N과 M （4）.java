import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[m];

        combi(0, 1);
    }

    static void combi(int cnt, int idx){
        if (cnt == m) {
            for (int i = 0 ; i < m; i ++) {
                System.out.print(visited[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= n ; i ++) {

            visited[cnt] = i;
            combi(cnt+1, i);
        }
    }
}
