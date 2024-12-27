import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int n, max = 0;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 0 ; h <= 100 ; h ++) {
            // 방문 배열 초기화 & 안전지역 초기화
            visited = new boolean[n][n];
            int count = 0;

            // bfs 돌 때 마다 count 증가시키기 ( 안전구역 )
            for (int x = 0; x < n ; x ++) {
                for (int y = 0 ; y < n ; y ++) {
                    if (!visited[x][y] && map[x][y] > h) {
                        bfs(x, y, h);
                        count ++;
                    }
                }
            }

            if (count == 0) break;

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static class Node{
        int x;
        int y;

        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int height) {

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 수면보다 높고 방문하지 않은 곳이라면
                if (map[nx][ny] > height && !visited[nx][ny]) {
                    q.add(new Node(nx ,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}