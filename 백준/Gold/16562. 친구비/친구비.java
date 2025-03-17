import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, sum, count;
    static int[] cost;
    static HashSet<Integer>[] friends;
    static PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o1.cost - o2.cost;
            }
    );

    static boolean[] visited;

    static class Node {
        int no;
        int cost;

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

        cost = new int[n];
        friends = new HashSet[n+1];
        visited = new boolean[n+1];
        count = n;

        for (int i = 1 ; i <= n ; i ++) {
            friends[i] = new HashSet<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i ++) {
            pq.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            friends[from].add(to);
            friends[to].add(from);
        }

        while(!pq.isEmpty()) {
            // 모든 노드를 방문했다면
            if (count == 0) {
                break;
            }
            Node cur = pq.poll();
            int next = cur.no;

            // 이미 방문한 친구라면
            if (visited[next]) continue;

            sum += cur.cost;

            if (k - sum >= 0) {
                bfs(next);
                count --;
            } else {
                break;
            }
        }

        if (sum <= k) {
            System.out.println(sum);
        } else {
            System.out.println("Oh no");
        }

    }

    static void bfs(int node) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : friends[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count --;
                }
            }
        }
    }
}