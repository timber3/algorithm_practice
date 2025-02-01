import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int l, r, c;
    static int sz, sx, sy, ez, ex, ey;

    static char[][][] map;
    static int[][][] visited;

    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args) throws Exception {

        while(true) {
            st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            map = new char[l][r][c];
            visited = new int[l][r][c];

            for (int i = 0 ; i < l ; i ++) {
                for (int j = 0 ; j < r ; j ++) {
                    String str = br.readLine();
                    for (int k = 0 ; k < c ; k ++) {

                        map[i][j][k] = str.charAt(k);

                        if (map[i][j][k] == 'S') {
                            sz = i;
                            sx = j;
                            sy = k;
                        }

                        if (map[i][j][k] == 'E') {
                            ez = i;
                            ex = j;
                            ey = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs();

            if (visited[ez][ex][ey] == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + visited[ez][ex][ey] + " minute(s).");
            }


        }
    }

    static class Node {
        int z;
        int x;
        int y;

        public Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {

        for (int i = 0 ; i < l ; i ++){
            for (int j = 0 ; j < r ; j ++) {
                for (int k = 0 ; k < c ; k ++) {
                    visited[i][j][k] = -1;
                }
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(sz, sx, sy));
        visited[sz][sx][sy] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cz = cur.z;
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 6 ; i ++) {
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= l || nx >= r || ny >= c ) continue;

                if (visited[nz][nx][ny] != -1 || map[nz][nx][ny] == '#') continue;

                q.add(new Node(nz,nx,ny));
                visited[nz][nx][ny] = visited[cz][cx][cy] + 1;
            }
        }
    }
}