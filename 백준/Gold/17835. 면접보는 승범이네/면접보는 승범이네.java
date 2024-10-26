import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;
    static long MAX = Long.MAX_VALUE;
    static ArrayList<Edge>[] map;
    static long[] d;
    static int[] arr;

    static class Edge {
        int v;
        long w;

        Edge (int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for (int i = 1 ; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }
        
        arr = new int[k];

        for (int i = 0 ; i < m ; i ++) {

            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[to].add(new Edge(from, weight));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < k ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // input

        dij();

        long disMax = 0;
        int maxIdx = -1;

        for (int i = 1 ; i <= n ; i ++) {
            if (disMax < d[i]) {
                disMax = d[i];
                maxIdx = i;
            }
        }

        System.out.print(sb.append(maxIdx).append("\n").append(disMax));
    }

    static void dij() {

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return (int) (o1.w - o2.w);
                }
        );

        d = new long[n+1];
        for (int i = 1; i <= n ; i ++) {
            d[i] = MAX;
        }

        for (int i = 0 ; i < k ; i ++) {
            d[arr[i]] = 0;
            pq.add(new Edge(arr[i], 0));
        }

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int cv = cur.v;
            long cw = cur.w;

            if (d[cv] < cw) continue;

            for (Edge e : map[cv]) {
                if (d[e.v] > d[cv] + e.w) {
                    d[e.v] = d[cv] + e.w;
                    pq.add(new Edge(e.v, d[e.v]));
                }
            }
        }
    }
}