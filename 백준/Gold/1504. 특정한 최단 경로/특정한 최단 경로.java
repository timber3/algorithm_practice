import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, E, t1, t2, MAX = Integer.MAX_VALUE;
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

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        for (int i = 1; i <= N ; i ++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, weight));
            map[to].add(new Edge(from, weight));
        }

        st = new StringTokenizer(br.readLine());

        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());

        // 1에서 출발해서 A -> B -> N 가 빠른지, B -> A -> N가 빠른지 보기
        // A -> B 나 B -> A 나 같음 ( 방향 x )
        dij(1);
        int st1 = d[t1];
        int st2 = d[t2];

        dij(t1);
        int t1d = d[N];

        dij(t2);
        int t2d = d[N];

        int t1t2 = d[t1];

        if (st1 == MAX || st2 == MAX || t1d == MAX || t2d == MAX || t1t2 == MAX)
            System.out.println(-1);
        else {
            int result = Math.min(st1 + t1t2 + t2d, st2 + t1t2 + t1d);

            System.out.println(result);
        }


    }

    public static void dij(int start) {

        // 다익스트라를 돌릴 때 마다 초기화
        d = new int[N+1];

        for (int i = 1 ; i <= N ; i ++) {
            d[i] = MAX;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o2.w - o1.w;
                }
        );

        pq.add(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {

            Edge cur = pq.poll();

            int cv = cur.v;
            int cw = cur.w;

            // 경로가 이미 최적화 되어있다면 더 할 필요 없으므로 continue;
            if (d[cv] < cw)
                continue;

            // 현재 도착한 노드에서 갈 수 있는 경로 탐색
            for (Edge e : map[cv]) {
                // 다음 경로까지의 거리가 현재까지의 거리 + 다음 경로의 가중치 보다 크면 경신해주기
                if (d[e.v] > e.w + d[cv]) {
                    d[e.v] = e.w + d[cv];
                    pq.add(e);
                }
            }
        }
    }

}