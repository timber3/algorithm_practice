import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, r;
    static char[][] map;
    static int[] h;
    static int[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j);
            }
        }

        r = Integer.parseInt(br.readLine());

        h = new int[r];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < r ; i ++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    static void solve() {
        // 1. 던진다
        // 2. 중력처리 한다.
        for (int i = 0 ; i < r ; i ++) {
            shoot(n - h[i], i % 2);
            gravity();
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void shoot(int height, int dir) {
        if (dir == 0) {
            for (int i = 0 ; i < m ; i ++) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    break;
                }
            }
        } else {
            for (int i = m-1 ; i >= 0 ; i --) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    break;
                }
            }
        }

    }

    static void gravity() {
        // 1. 클러스터가 나뉘었는지 확인한다.
        // 2. 클러스터 바닥이 비어있는지 확인한다.
        // 3. 비어있으면 중력처리 한다.
        visited = new int[n][m];
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                visited[i][j] = -1;
            }
        }

        int count = 0;

        // 클러스터를 확인한다.
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] == 'x' && visited[i][j] == -1) {
                    // 중력 적용 대상이라면
                    if (bfs(i, j, count)) {
                        // 바닥에서 부터 count에 해당하는 flood 를 찾았으면 바닥과의 가장 짧은 거리를 찾아서 내리기
                        int minDis = Integer.MAX_VALUE;

                        // 중력을 적용했을 때 가장 먼저 닿는 곳 찾기.
                        for (int xIdx = 0 ; xIdx < m ; xIdx ++) {
                            int dis = 0;
                            for (int hIdx = n - 1 ; hIdx >= 0 ; hIdx --) {
                                // 밑에서부터 올라가면서 x를 만났는데
                                if (map[hIdx][xIdx] == 'x') {
                                    // 해당 클러스터가 아닐 경우 카운트를 초기화 해야함. 다른 클러스터의 x를 만나는 경우
                                    if (visited[hIdx][xIdx] != count) {
                                        dis = 0;
                                    }
                                    // 해당 클러스터의 x를 만난 경우
                                    else {
                                        if (minDis > dis) minDis = dis;
                                        break;
                                    }
                                }
                                else if (map[hIdx][xIdx] == '.') {
                                    dis ++;
                                }
                            }
                        }

                        // minDis 만큼 클러스터 내리기
                        for (int xIdx = 0; xIdx < m ; xIdx ++) {
                            for (int height = 0 ; height < n ; height ++) {
                                int hIdx = n - 1 - height;

                                if (map[hIdx][xIdx] == 'x' && visited[hIdx][xIdx] == count) {
                                    map[hIdx+minDis][xIdx] = 'x';
                                    map[hIdx][xIdx] = '.';
                                    visited[hIdx+minDis][xIdx] = count;
                                    visited[hIdx][xIdx] = -1;
                                }
                            }
                        }
                        break;
                    }
                    count ++;
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // bfs 수행하면서 클러스터 밑면에 바닥 or x가 있는지 확인하기
    static boolean bfs(int x, int y, int count) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        visited[x][y] = count;
        boolean target = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 아래 방향이고 바닥이라면 (바닥에 한칸이라도 붙어있으면 중력 적용 대상이 아님)
                if (i == 3 && nx >= n) {
                    target = false;
                }

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] != -1 || map[nx][ny] == '.') continue;


                q.add(new Node(nx, ny));
                visited[nx][ny] = count;
            }
        }

        return target;
    }
}