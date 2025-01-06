import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int n, m, g, r, max = Integer.MIN_VALUE;
    static int[][] map;
    static Fluid[][] visited;
    static ArrayList<Node> avail = new ArrayList<>();
    static boolean[] used;

    public static class Fluid {
        int color;
        int time;

        public Fluid(int color, int time) {
            this.color = color;
            this.time = time;
        }
    }

    public static class Node {
        int x;
        int y;
        int color;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 0 : 흰색    1 : 초록색    2 : 빨간색
        public void spread(int color) {
            this.color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                // 0 : 호수  1 : 흰색 땅  2 : 배양가능 땅
                map[i][j] = Integer.parseInt(st.nextToken());
                // 배양 가능한 땅의 리스트를 갖고 있는다.
                if (map[i][j] == 2) {
                    avail.add(new Node(i, j));
                }
            }
        }

        // 배양액을 뿌린 땅 체크용
        used = new boolean[avail.size()];

        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int depth, int gidx, int ridx) {
        if (depth == r + g) {
            // 꽃 개수
            int count = 0;

            visited = new Fluid[n][m];

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < m ; j ++) {
                    visited[i][j] = new Fluid(0, -1);
                }
            }

            // 배양액 투입
            ArrayDeque<Node> q = new ArrayDeque<>();

            for (int i = 0 ; i < avail.size() ; i++) {
                // 배양액을 뿌릴 자리라면
                if (used[i]) {
                    Node temp = avail.get(i);
                    q.add(temp);
                    // 배양액을 뿌린 자리의 배양액 색깔 및 시간 초기화
                    visited[temp.x][temp.y].color = temp.color;
                    visited[temp.x][temp.y].time = 0;
                }
            }

            while(!q.isEmpty()) {
                Node cur = q.poll();
                int cx = cur.x;
                int cy = cur.y;

                if (visited[cx][cy].color == 3) continue;

                for (int i = 0 ; i < 4 ; i ++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    // 호수라면 못감
                    if (map[nx][ny] == 0) continue;

                    // 꽃이 펴 있으면 못감
                    if (visited[nx][ny].color == 3) continue;

                    // 이미 배양액이 뿌려져있는데 시간은 같으면서 색깔이 다르면 꽃 만들기
                    if (visited[nx][ny].time == (visited[cx][cy].time + 1) && (visited[nx][ny].color + visited[cx][cy].color) == 3) {
                        // 꽃으로 만들어 버리기
                        visited[nx][ny].color = 3;
                        // visited 체크 해주기
                        visited[nx][ny].time = visited[cx][cy].time + 1;
                        count ++;
                    }

                    // 아무것도 뿌려진게 없으면 뿌리기
                    if (visited[nx][ny].time == -1) {
                        visited[nx][ny].color = visited[cx][cy].color;
                        visited[nx][ny].time = visited[cx][cy].time + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }

            max = Math.max(count, max);

            return;
        }

        // 초록색 먼저 뿌리기 (덜 뿌렸으면 먼저 뿌리고 가기)
        if (depth < g) {
            for (int i = gidx ; i < avail.size() ; i ++) {
                if (!used[i]) {
                    used[i] = true;
                    avail.get(i).spread(1);
                    dfs(depth + 1, i, ridx);
                    used[i] = false;
                    avail.get(i).spread(0);
                }
            }
        } else {
            for (int i = ridx ; i < avail.size() ; i ++) {
                if (!used[i]) {
                    used[i] = true;
                    avail.get(i).spread(2);
                    dfs(depth + 1, gidx, i);
                    used[i] = false;
                    avail.get(i).spread(0);
                }
            }
        }
    }
}