// 4:18
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o1.cost - o2.cost;
            }
    );

    static PriorityQueue<Integer> selectedEdge = new PriorityQueue<>(
            (o1, o2) -> {
                return o2 - o1;
            }
    );

    // union-find
    static int[] parent;

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        // 2 ~ 100,000
        n = Integer.parseInt(st.nextToken());
        // 1 ~ 1,000,000
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        // 각 노드의 대장은 자기 자신으로 초기화
        for (int i = 1 ; i <= n ; i ++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(from, to, cost));
        }

        while(!allConnect(1) && !pq.isEmpty()) {

            Edge cur = pq.poll();

            // 대장 노드가 다를 경우에만 union 해주기
            if (find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                selectedEdge.add(cur.cost);
            }
        }

        // 가장 큰거 하나 버리기
        if (!selectedEdge.isEmpty()) {
            selectedEdge.poll();
        }

        int result = 0;

        while(!selectedEdge.isEmpty()) {
            result += selectedEdge.poll();
        }

        System.out.println(result);

    }

    // node의 대장 노드 찾기
    static int find(int node) {

        // 대장 노드가 자기 자신이 아닌 경우 (=내가 대장이 아닌 경우) =>  대장 노드가 뭔지 표시
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 대장이 다르다면?
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static boolean allConnect(int node) {
        // 대장노드
        int root = find(node);

        for (int i = 1 ; i <= n ; i ++) {
            if (root != parent[i]) {
                return false;
            }
        }
        return true;
    }
}