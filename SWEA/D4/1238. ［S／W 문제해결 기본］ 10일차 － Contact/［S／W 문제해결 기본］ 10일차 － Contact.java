import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, start;
    static int[][] Map;
    static int[] dist;
    static int result, MaxDist;

    public static void main(String[] args) throws IOException {

        for (int t = 0 ; t < 10 ; t ++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            Map = new int[101][101];
            dist = new int[101];

            Arrays.fill(dist, -1);

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                Map[from][to] = 1;
            }

            bfs();

            for (int i = 1; i <= 100; i++) {
                if (dist[i] >= MaxDist) {
                    MaxDist = dist[i];
                    result = Math.max(result, i);
                }
            }

            System.out.printf("#%d %d\n", t+1, result);
            
            result = MaxDist = 0;
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 100; i++) {
                if (Map[cur][i] == 1 && dist[i] == -1) {
                    q.add(i);
                    dist[i] = dist[cur] + 1;
                }
            }
        }
    }
}
