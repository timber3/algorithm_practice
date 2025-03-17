import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, k, sum;
    static List<Integer>[] friends;
    static PriorityQueue<Node> pq;
    static boolean[] visited;

    static class Node {
        int no, cost;
        public Node(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friends = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        for (int i = 1; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pq.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            friends[from].add(to);
            friends[to].add(from);
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.no]) continue;  // 방문한 친구 건너뛰기

            sum += cur.cost;
            if (sum > k) break;

            bfs(cur.no);
        }

        System.out.println(sum > k ? "Oh no" : sum);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : friends[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
