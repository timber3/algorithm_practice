import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, dirties = 1, min;
    static int sx, sy;
    static char[][] map;
    static boolean[] visited;
    static ArrayList<Node> list;
    static int[][] dist;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        while(true) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            map = new char[n][m];
            dirties = 0;
            list = new ArrayList<>();
            min = Integer.MAX_VALUE;

            ArrayDeque<Node> q = new ArrayDeque<>();

            for (int i = 0 ; i < n ; i ++) {
                String str = br.readLine();
                for (int j = 0 ; j < m ; j ++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') {
                        map[i][j] = (char)(dirties + '0');
                        dirties ++;
                        q.add(new Node(i, j));
                    }

                    // 시작지점 저장
                    if (map[i][j] == 'o') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            // 0: 시작위치   나머지: 더러운 위치
            list.add(new Node(sx, sy));
            while(!q.isEmpty()) {
                list.add(q.poll());
            }

            dist = new int[dirties+1][dirties+1];
            visited = new boolean[dirties+1];

            // list 의 크기 ( 더러운 곳 개수 ) 만큼 bfs를 진행한다 -> 시작 위치에서 다른 더러운 곳 위치까지의 거리 측정
            for (int i = 0 ; i < list.size() ; i ++) {
                distBfs(list.get(i), i);
            }

            dfs(0, 0, 0);

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }
        }
    }

    // 각 지점에서 다른 지점까지의 거리를 측정하는 BFS
    static void distBfs(Node start, int idx) {
        int[][] visit = new int[n][m];
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                visit[i][j] = -1;
            }
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(start);
        visit[start.x][start.y] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'x' || visit[nx][ny] != -1) continue;

                q.add(new Node(nx ,ny));
                visit[nx][ny] = visit[cx][cy] + 1;
            }
        }

        for (int i = 0 ; i < list.size() ; i++) {
            Node target = list.get(i);
            dist[idx][i] = visit[target.x][target.y];
        }
    }

    static void dfs(int depth, int sum, int start) {
        if (depth == dirties) {
            if (min > sum) min = sum;
            return;
        }

        // 시작 위치는 따로 돌려주기
        if (depth == 0) {
            for (int i = 1 ; i < list.size() ; i++) {
                if (dist[0][i] != -1) {
                    visited[i] = true;
                    dfs(depth + 1, sum + dist[start][i], i);
                    visited[i] = false;
                }
            }
        }

        for (int i = 1 ; i < list.size() ; i++) {
            if (start != i && !visited[i] && dist[start][i] != -1) {
                visited[i] = true;
                dfs(depth + 1, sum + dist[start][i], i);
                visited[i] = false;
            }
        }
    }
}