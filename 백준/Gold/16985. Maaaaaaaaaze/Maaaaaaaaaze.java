import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int count, min = Integer.MAX_VALUE;
    static int[][][] map = new int[5][5][5];
    static int[][][] visited;
    static boolean[] used;

    static int[] dk = {-1, 1, 0, 0, 0, 0}; // 위층 아래층
    static int[] dx = {0, 0, 0, 0, -1, 1}; // 상 하
    static int[] dy = {0, 0, 1, -1, 0, 0}; // 좌 우

    public static void main(String[] args) throws Exception {
        for (int k = 0 ; k < 5 ; k ++) {
            for (int i = 0 ; i < 5 ; i ++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < 5 ; j ++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        used = new boolean[5];

        dfs(0, new int[5][5][5]);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    static void dfs(int depth, int[][][] result) {
        if (depth == 5) {
            // 탈출 시작
            int val = bfs(result);
            if (val != -1 && min > val) {
                min = val;
            }
            return;
        }

        for (int i = 0 ; i < 5 ; i ++) {
            if (!used[i]) {
                used[i] = true;

                int[][] temp = map[i];

                for (int j = 0; j < 4; j ++) {
                    temp = rotate(temp);
                    result[depth] = temp;
                    dfs(depth + 1, result);
                }

                used[i] = false;
            }
        }


    }

    static int[][] rotate(int[][] map) {
        int[][] temp = new int[5][5];

        for (int i = 0 ; i < 5 ; i ++) {
            for (int j = 0 ; j < 5 ; j ++) {
                temp[j][5-1-i] = map[i][j];
            }
        }

        return temp;
    }

    static class Node {
        int k;
        int x;
        int y;

        public Node(int k, int x, int y) {
            this.k = k;
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int[][][] MAP) {
        // 시작을 못하면 빠꾸
        if (MAP[0][0][0] == 0) {
            return -1;
        }

        visited = new int[5][5][5];

        for (int i = 0 ; i < 5 ; i ++) {
            for (int j = 0 ; j < 5 ; j ++) {
                for (int k = 0 ; k < 5 ; k ++) {
                    visited[i][j][k] = -1;
                }
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        visited[0][0][0] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int ck = cur.k;
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 6 ; i ++) {
                int nk = ck + dk[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nk < 0 || nx < 0 || ny < 0 || nk >= 5 || nx >= 5 || ny >= 5 || visited[nk][nx][ny] != -1) continue;

                if (MAP[nk][nx][ny] == 1) {
                    q.add(new Node(nk, nx, ny));
                    visited[nk][nx][ny] = visited[ck][cx][cy] + 1;
                }
            }
        }

        return visited[4][4][4];

    }
}
