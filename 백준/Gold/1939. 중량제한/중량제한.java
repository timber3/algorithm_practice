import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Edge>[] map;
    static int n, m;
    static int start, end, max = Integer.MAX_VALUE;
    static int[] dis;

    public static class Edge {
        int v;
        int w;
        public Edge (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dis = new int[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            dis[i] = 0;
        }

        map = new ArrayList[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < m ; i ++ ) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, weight));
            map[to].add(new Edge(from, weight));

        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // input

        dij(start);

        System.out.println(dis[end]);

    }

    public static void dij(int start) {
        // pq 는 무게가 큰 순으로 poll
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o2.w - o1.w;
                }
        );

        // 현재 노드는 최대값
        pq.add(new Edge(start, max));
        dis[start] = max;

        while(!pq.isEmpty()) {
            // 갈 수 있는 간선 중에서 가중치(허용무게)가 큰 순으로 이동해야 함.
            Edge cur = pq.poll();

            int cv = cur.v;
            int cw = cur.w;

            // 더 작은 것들로 넘어가려고 하면 컷하기
            if (dis[cv] > cw) continue;

            // 일단 큰 것들 부터 먼저 확인하기 때문에
            // 다음 노드에 해당하는 dis는 갈 수 있는 경로중 지나치는 무게중 최솟값 중 최대값 들어가있음
            // 1. 현재까지의 dis 값
            // 2. 다음 노드로 가는데 무게 값
            
            // 1, 2 중에서 작은 값과 다음 dis[e.v]를 비교해야 함  => 1, 2 중에서 더 큰 값은 어짜피 의미없기 때문
            for (Edge e : map[cv]) {
                int minWeight = Math.min(dis[cv], e.w);

                if (minWeight > dis[e.v]) {
                    dis[e.v] = minWeight;
                    pq.add(new Edge(e.v, minWeight));
                }
            }
        }
    }
}