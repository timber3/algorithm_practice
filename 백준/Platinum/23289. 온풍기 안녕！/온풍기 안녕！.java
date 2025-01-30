import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int r, c, k, w, count;
    static int[][] map;
    static boolean[][][][] wall;
    static ArrayList<Node> targets = new ArrayList<>();
    static ArrayList<Node> heaters = new ArrayList<>();

    static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] nextDir = {-1, 0, 1};

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        // 2 <= r, c <= 20
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        // (x1, y1) , (x2, y2) 사이에 벽이 있으면 true
        wall = new boolean[r][c][r][c];

        for (int i = 0 ; i < r ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < c ; j ++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 5) {
                    targets.add(new Node(i, j));
                } else if (val != 0) {
                    heaters.add(new Node(i, j ,val-1));
                }
            }
        }

        w = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < w ; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            // 위에 벽 생김
            if (t == 0) {
                wall[x][y][x-1][y] = true;
                wall[x-1][y][x][y] = true;
            }
            // 오른쪽에 벽 생김
            if (t == 1) {
                wall[x][y][x][y+1] = true;
                wall[x][y+1][x][y] = true;
            }
        }

        while(true) {
            boolean flag = true;
            count ++;

            if (count > 100) break;

            for (Node heater: heaters) {
                heaterBlow(heater.x, heater.y, heater.dir);
            }

            tempAvg();

            oneDegreeMinus();

            for (Node target: targets) {
                if (map[target.x][target.y] < k) {
                    flag = false;
                }
            }

            if (flag) break;
        }

        System.out.println(count);
    }

    // 같은 곳에 여러번 불면 합적용
    // 바람은 bfs로 퍼저나가는 형식. => 벽에 막히면 못 지나감
    static void heaterBlow(int hx, int hy, int dir) {
        // 온풍기 바람 모양으로 바람을 분다.
        int sx = hx + dx[dir];
        int sy = hy + dy[dir];

        int[][] visited = new int[r][c];

        for(int i = 0 ; i < r ; i ++) {
            for (int j = 0 ; j < c ; j ++) {
                visited[i][j] = -1;
            }
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = 5;
        map[sx][sy] += 5;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            if (visited[cx][cy] == 1) continue;

            for (int i = 0 ; i < 3 ; i ++) {
                int nx = 0;
                int ny = 0;

                if (dir == 0 || dir == 1) {
                    nx = cx + dx[dir] + nextDir[i];
                    ny = cy + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] != -1) continue;

                    if (wall[cx][cy][cx+nextDir[i]][cy] || wall[cx+nextDir[i]][cy][nx][ny]) continue;

                } else {
                    nx = cx + dx[dir];
                    ny = cy + dy[dir] + nextDir[i];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] != -1) continue;

                    if (wall[cx][cy][cx][cy+nextDir[i]] || wall[cx][cy+nextDir[i]][nx][ny]) continue;

                }

                q.add(new Node(nx ,ny));
                visited[nx][ny] = visited[cx][cy] - 1;
                map[nx][ny] += visited[nx][ny];
            }
        }
    }

    static void tempAvg() {
        int[][] temp = new int[r][c];

        for (int i = 0 ; i < r; i ++) {
            for (int j = 0 ; j < c ; j ++) {

                int cx = i;
                int cy = j;

                for (int d = 0 ; d < 4 ; d ++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                    // 벽이 있거나, 다음 갈 곳이 더 크면 안됨.
                    if (wall[cx][cy][nx][ny]) continue;

                    if (map[cx][cy] > map[nx][ny]) {
                        int val = (map[cx][cy] - map[nx][ny]) / 4;
                        temp[nx][ny] += val;
                        temp[cx][cy] -= val;
                    }
                }
            }
        }

        // 반영해주기
        for (int i = 0 ; i < r ; i ++){
            for (int j = 0 ; j < c ; j ++) {
                map[i][j] += temp[i][j];
            }
        }
    }

    static boolean[][] oneDegree;

    static void oneDegreeMinus() {
        oneDegree = new boolean[r][c];

        for (int i = 0 ; i < r ; i ++) {
            if (map[i][0] > 0) oneDegree[i][0] = true;
            if (map[i][c-1] > 0) oneDegree[i][c-1] = true;
        }
        for (int i = 0 ; i < c; i ++) {
            if (map[0][i] > 0) oneDegree[0][i] = true;
            if (map[r-1][i] > 0) oneDegree[r-1][i] = true;
        }

        for (int i = 0 ; i < r ; i ++) {
            for (int j = 0 ; j < c ; j ++) {
                if (oneDegree[i][j]) map[i][j] --;
            }
        }
    }

}