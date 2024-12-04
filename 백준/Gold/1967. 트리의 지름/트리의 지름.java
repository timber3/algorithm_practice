import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static ArrayList<int[]>[] tree;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[parent].add(new int[]{child, cost});
            tree[child].add(new int[]{parent, cost});
        }

        int[] firstBfs = bfs(1);
        int farthestNode = firstBfs[0];

        int[] secondBfs = bfs(farthestNode);
        System.out.println(secondBfs[1]);
    }

    static int[] bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int maxDistance = 0;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }

            for (int[] next : tree[node]) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    queue.add(new int[]{next[0], distance + next[1]});
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}