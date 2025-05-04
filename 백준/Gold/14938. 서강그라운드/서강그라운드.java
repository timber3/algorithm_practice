import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, r, max;
    static int[] items;
    static List<Edge>[] graph;
    static int[] d;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i ++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < r ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));

        }

        for (int i = 1 ; i <= n ; i ++) {
            int result = dij(i);
            if (result > max) max = result;

        }

        System.out.println(max);
    }

    static int dij(int start) {
        d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();
            // 이미 효율적인 경로가 있으면 pass
            if (d[cur.to] < cur.cost) continue;

            for (Edge next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;

                if (newCost <= m) {
                    if (newCost < d[next.to]) {
                        d[next.to] = newCost;
                        pq.add(new Edge(next.to, newCost));
                    }
                }
            }
        }

        int count = 0;

        for (int i = 1 ; i <= n ; i++) {
            if (d[i] != Integer.MAX_VALUE) {
                count += items[i];
            }
        }

        return count;
    }
}