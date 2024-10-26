import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, start, des, MAX = Integer.MAX_VALUE;
    static ArrayList<Edge>[] map;
    static int[] d;

    static class Edge {
        int v;
        int w;

        Edge (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for (int i = 1 ; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }

        d = new int[n+1];
        for (int i = 1; i <= n ; i ++) {
            d[i] = MAX;
        }

        for (int i = 0 ; i < m ; i ++) {

            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());

        // input

        dij(start);

        System.out.println(d[des]);

    }

    static void dij(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1.w - o2.w;
                }
        );

        pq.add(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int cv = cur.v;
            int cw = cur.w;

            if (d[cv] < cw) continue;

            for (Edge e : map[cv]) {
                if (d[e.v] > d[cv] + e.w) {
                    d[e.v] = d[cv] + e.w;
                    pq.add(e);
                }
            }
        }
    }
}