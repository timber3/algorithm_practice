import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, groupIdx = 1;
    static int[][] map, result;
    static int[][] visited;
    static HashMap<Integer, Integer> group = new HashMap<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        result = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m; j ++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                // 0 일때 bfs를 동작시켜서 연결된 애들을 그룹지어 규모를 측정한다.
                // visited 는 방문체크 + 그룹 구별
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    bfs(i,j,groupIdx++);
                }
            }
        }

        // result 배열 채우기
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {

                if (map[i][j] == 1) {
                    int sum = 0;

                    HashSet<Integer> set = new HashSet<>();
                    for (int d = 0 ; d < 4 ; d ++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        if (!set.contains(visited[nx][ny]) && map[nx][ny] == 0) {
                            set.add(visited[nx][ny]);
                            sum += group.get(visited[nx][ny]);
                        }
                    }

                    result[i][j] = (sum + 1) % 10;
                } else {
                    result[i][j] = 0;
                }
            }
        }


        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int idx) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        visited[x][y] = idx;
        int count = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = idx;
                    count ++;
                }
            }
        }

        // 해당 그룹의 크기가 count 만큼의 크기임
        group.put(idx, count);
    }
}