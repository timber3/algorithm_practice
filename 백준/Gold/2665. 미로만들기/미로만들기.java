import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] map;

    static int[][] d;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        d = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dij();

        System.out.println(d[n - 1][n - 1]);
    }

    static void dij() {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        d[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int cx = cur.x;
            int cy = cur.y;

            if (d[cx][cy] < cur.cost) continue;

            for (int i = 0 ; i < 4 ; i ++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n ) continue;

                int nextCost = d[cx][cy] + (map[nx][ny] == 0 ? 1 : 0);

                // 비용 갱신 조건을 큐에 넣기 전에 판단
                if (nextCost < d[nx][ny]) {
                    d[nx][ny] = nextCost;
                    pq.offer(new Node(nx, ny, nextCost));
                }
            }

        }
    }
}