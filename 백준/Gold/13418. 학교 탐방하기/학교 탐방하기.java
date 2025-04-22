import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

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

        graph = new ArrayList[n+1];

        for (int i = 0 ; i <= n ; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i <= m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        int min = minPrim(0);
        int max = maxPrim(0);

        System.out.println(Math.abs(max - min));
    }

    static int minPrim(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.cost - o1.cost;
        });

        visited = new boolean[n+1];
        visited[start] = true;
        int sum = 0;

        for (Edge e : graph[start]) {
            pq.add(e);
        }

        while(!pq.isEmpty()) {

            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            if (cur.cost == 0) {
                sum++;
            }

            for (Edge e : graph[cur.to]) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }
        }

        return sum * sum;
    }

    static int maxPrim(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        visited = new boolean[n+1];
        visited[start] = true;
        int sum = 0;

        for (Edge e : graph[start]) {
            pq.add(e);
        }

        while(!pq.isEmpty()) {

            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            if (cur.cost == 0) {
                sum++;
            }

            for (Edge e : graph[cur.to]) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }
        }

        return sum * sum;
    }
}