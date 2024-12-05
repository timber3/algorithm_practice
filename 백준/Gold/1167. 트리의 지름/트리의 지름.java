import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, max = 0;
    static ArrayList<Node>[] tree;
    static int[] visited;

    public static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n ; i ++) {

            String str = br.readLine();

            String[] temp = str.split(" ");

            int from = Integer.parseInt(temp[0]);

            for (int j = 1 ; j < temp.length - 2; j += 2) {
                int to = Integer.parseInt(temp[j]);
                int cost = Integer.parseInt(temp[j+1]);

                tree[from].add(new Node(to, cost));
                tree[to].add(new Node(from, cost));
            }
        }

        // 루트 노드에서 가장 먼 노드 찾기
        int firstBfs = bfs(1);
        int secondBfs = bfs(firstBfs);

        System.out.println(visited[secondBfs]);

    }

    public static int bfs(int start) {

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(start);

        // 거리/방문 배열
        visited = new int[n+1];
        Arrays.fill(visited, -1);

        visited[start] = 0;

        int maxDist = 0;
        int nodeNum = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0 ; i < tree[cur].size(); i++) {
                Node next = tree[cur].get(i);

                if (visited[next.to] == -1) {

                    visited[next.to] = visited[cur] + next.cost;
                    q.add(next.to);

                    if (maxDist < visited[next.to]) {
                        maxDist = visited[next.to];
                        nodeNum = next.to;
                    }
                }
            }
        }
        return nodeNum;
    }
}