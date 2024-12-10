import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[][] dist;

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        // n : 2 ~ 100
        n = Integer.parseInt(br.readLine());
        // m : 1 ~ 100,000
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];

        for(int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                dist[i][j] = -1;
            }
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (dist[from][to] == -1) {
                dist[from][to] = cost;
            } else if (dist[from][to] > cost) {
                dist[from][to] = cost;
            }
        }

        floyd();

        for(int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                if (dist[i][j] == -1) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void floyd() {

        for (int k = 1 ; k <= n ; k ++) {
            for (int i = 1 ; i <= n ; i ++) {
                for (int j = 1 ; j <= n ; j ++) {

                    if (i == j || j == k || i == k) continue;

                    if (dist[i][k] != -1 && dist[k][j] != -1) {
                        if (dist[i][j] > dist[i][k] + dist[k][j] || dist[i][j] == -1) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

    }
}