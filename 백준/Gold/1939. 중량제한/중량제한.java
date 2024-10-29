import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, max = Integer.MAX_VALUE;
    static int start, end;
    static ArrayList<Edge>[] map;
    static int[] dis;

    public static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        dis = new int[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0 ; i <= n ; i++) {
            dis[i] = 0;
        }

        for (int i = 0 ; i < m ; i ++) {
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

        // 중량 제한이 큰거 먼저 뽑기
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o2.w - o1.w;
                }
        );

        pq.add(new Edge(start, max));
        dis[start] = max;

        // dis[n] = 해당 위치까지 가는데 무게 제한들 중에서 최소 중 최대가 들어간 것.

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int cv = cur.v;
            int cw = cur.w;

            // 다음 가는 곳의 무게 중 최소보다 더 작으면 해당 값으로 초기화 할 필요가 없음.
            if (dis[cv] > cw) continue;

            for (Edge e : map[cur.v]) {

                // 현재 노드까지의 최소 무게와 건너갈 다리의 무게 비교후 작은값으로 비교해야함.
                int temp = Math.min(cw, e.w);

                if (dis[e.v] < temp) {
                    dis[e.v] = temp;
                    pq.add(new Edge(e.v, dis[e.v]));
                }
            }
        }
    }

}