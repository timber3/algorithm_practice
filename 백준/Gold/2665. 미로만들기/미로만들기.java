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

    static class Node implements Comparable<Node>{
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
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

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n ) continue;

                // 다음 갈 곳이 흰 방이면 비용 x
                if (map[nx][ny] == 1 && d[nx][ny] > d[cx][cy]) {
                    d[nx][ny] = d[cx][cy];
                    pq.offer(new Node(nx, ny, d[cx][cy]));
                }
                // 다음 갈 곳이 검은 방이면 비용 + 1
                if (map[nx][ny] == 0 && d[nx][ny] > d[cx][cy] + 1) {
                    d[nx][ny] = d[cx][cy] + 1;
                    pq.offer(new Node(nx, ny, d[cx][cy] + 1));
                }
            }

        }
    }
}