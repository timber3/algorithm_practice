import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, min;
    static int[][] map;
    static boolean[][][][] visited;

    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 몇개의 벽을 부순 상태로 낮인지 밤인지에 따른 방문 횟수
        // 0: 낮    1: 밤
        visited = new boolean[n][m][k+1][2];

        min = -1;

        bfs();

        System.out.println(min);
    }

    static class Node {
        int x;
        int y;
        int dist;
        int c;
        int d;

        public Node(int x, int y, int dist, int c, int d) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.c = c;
            this.d = d;
        }
    }

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1,0,0)); //x, y, dist, boom, day
        visited[0][0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cdist = cur.dist;
            int cc = cur.c;
            int cd = cur.d;

            if(cx == n-1 && cy == m-1) {
                min = cur.dist;
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd ^ 1;

                if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;

                if(map[nx][ny] == 0) {
                    if(cd == 0 && !visited[nx][ny][cc][nd]) {
                        q.add(new Node(nx,ny,cur.dist+1,cc,nd));
                        visited[nx][ny][cc][nd] = true;
                    }
                    else if(cd == 1 && !visited[nx][ny][cc][nd]){
                        q.add(new Node(nx,ny,cur.dist+1,cc,nd));
                        visited[nx][ny][cc][nd] = true;
                    }
                }else { //낮은 0 밤은 1
                    if(cc < k && cd == 0 && !visited[nx][ny][cc+1][nd]) {
                        visited[nx][ny][cc+1][nd] = true;
                        q.add(new Node(nx,ny,cur.dist+1,cc+1,nd));
                    }else if(cc < k && cd == 1 && !visited[cx][cy][cc][nd]) {
                        visited[cx][cy][cc][nd] = true;
                        q.add(new Node(cx,cy,cur.dist+1,cc,nd));
                    }
                }

            }

        }
    }
}