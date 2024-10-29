import java.util.*;
import java.io.*;

public class Main {

    // 최대값 중에서 최소 구하기 -> 이분탐색

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Edge>[] map;
    static int n, m;
    static int start, end, max = Integer.MAX_VALUE;
    static int[] visited;

    public static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
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

        int left = 1;
        int right = 1_000_000_000;
        int result = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            // 10억 이하의 값에서 bfs 가 성공한다면(탐색이 가능하다면 -> mid 값 이하의 경로는 갈 수 없다는 전제 하에)
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean bfs(int target) {

        ArrayDeque<Edge> q = new ArrayDeque<>();

        q.add(new Edge(start, 0));

        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }

        visited[start] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            int cv = cur.v;

            for (Edge e : map[cv]) {
                if (e.w >= target && visited[e.v] == -1) {
                    q.add(new Edge(e.v, e.w));
                    visited[e.v] = 1;
                }
            }
        }

        if (visited[end] == -1) {
            return false;
        }

        return true;

    }


}