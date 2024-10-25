import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, start, end, MAX = Integer.MAX_VALUE;
    static ArrayList<Edge>[] map;
    static int[] dis, pre;

    public static void main(String[] args) throws Exception {

        // 다익스트라는 음수 가중치의 간선이 없을 때

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

//        map = new int[n+1][n+1];
        map = new ArrayList[n+1];
        dis = new int[n+1];
        pre = new int[n+1];

        for (int i = 1; i <= n ; i ++) {
            map[i] = new ArrayList<Edge>();
        }

        for (int i = 1 ; i <= n ; i ++) {
            dis[i] = MAX;
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to,cost));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        // input

        dij(start);

        System.out.println(dis[end]);

        ArrayDeque<Integer> st = new ArrayDeque<>();

        int nxt = end;

        st.add(nxt);

        while(nxt != start) {
            nxt = pre[nxt];
            st.add(nxt);
        }

        System.out.println(st.size());

        int size = st.size();

        for(int i = 0 ; i < size ; i++) {
            System.out.print(st.pollLast() + " ");
        }

    }

    static void dij(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.w - o1.w;
        });

        pq.add(new Edge(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()) {

            Edge cur = pq.poll();
            int cv = cur.v;
            int cw = cur.w;
            
            if (dis[cv] < cw)
                continue;

            for(Edge next : map[cv]) {
                if (dis[next.v] > dis[cv] + next.w) {
                    dis[next.v] = dis[cv] + next.w;
                    pre[next.v] = cv;
                    pq.add(new Edge(next.v, dis[next.v]));
                }
            }
        }
    }

    static class Edge {
        int v;
        int w;

        Edge (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

}