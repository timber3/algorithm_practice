import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    list.add(bfs(i,j));
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (int result: list) {
            System.out.println(result);
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y) {

        visited[x][y] = true;

        ArrayDeque<Node> q = new ArrayDeque<Node>();

        q.add(new Node(x, y));

        int count = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count ++;
                }
            }
        }

        return count;
    }
}