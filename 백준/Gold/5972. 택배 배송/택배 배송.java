import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] d;

    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.cost - o2.cost;
    });
    static ArrayList<Edge>[] graph;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= n ; i ++)
            d[i] = Integer.MAX_VALUE;

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));

        }

        dij();

        System.out.println(d[n]);
    }

    static void dij() {

        ArrayDeque<Edge> q = new ArrayDeque<>();

        d[1] = 0;
        pq.offer(new Edge(1, 0));

        while(!pq.isEmpty()) {
            // 비용 낮은 곳 부터 꺼내서
            Edge cur = pq.poll();

            // 이미 좋은 경로가 있다면 pass
            if (d[cur.to] < cur.cost) continue;

            for (Edge e : graph[cur.to]) {
                int next = e.to;
                int newDist = cur.cost + e.cost;

                if (d[next] > newDist) {
                    d[next] = newDist;
                    pq.offer(new Edge(next, newDist));
                }
            }
        }


    }
}