import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int T, n, m, count;
    static boolean reBfs;
    static char[][] map;
    static boolean[][] visited;
    static HashMap<Character, ArrayList<Node>> doorPos;
    static HashSet<Character> keys;

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            doorPos = new HashMap<>();
            keys = new HashSet<>();
            count = 0;
            reBfs = true;

            for (int i = 0; i < n ; i ++) {
                String str = br.readLine();
                for (int j = 0 ; j < m ; j ++) {
                    map[i][j] = str.charAt(j);

                    // 만약 문이라면 위치를 저장해준다. ( 똑같은 문이 여러개일 수 있음 )
                    if (map[i][j] != '.' && map[i][j] != '*' && map[i][j] != '$' && map[i][j] >= 65 && map[i][j] < 97) {
                        if (!doorPos.containsKey(map[i][j])) {
                            doorPos.put(map[i][j], new ArrayList<>());
                            doorPos.get(map[i][j]).add(new Node(i,j));
                        } else {
                            doorPos.get(map[i][j]).add(new Node(i,j));
                        }
                    }
                }
            }

            String str = br.readLine();

            int size = str.length();

            for (int i = 0 ; i < size ; i ++) {
                keys.add(str.charAt(i));
            }
            // input

            while(reBfs) {
                // 초기화
                visited = new boolean[n][m];
                reBfs = false;

                //bfs
                for (int i = 0 ; i < m ; i ++) {
                    // 외벽 가로줄 (방문한 적 없고, 빈칸이거나 혹은, 열 수 있는 문이거나 열쇠면 , 혹은 달러인 경우)
                    if (!visited[0][i] && (map[0][i] == '.' || keys.contains(Character.toLowerCase(map[0][i])) || map[0][i] >= 97 || map[0][i] == '$')) {
                        if (map[0][i] == '$') {
                            count ++;
                            map[0][i] = '.';
                        }
                        if (map[0][i] >= 97) {
                            keys.add(map[0][i]);
                            map[0][i] = '.';
                        }
                        bfs(0,i);
                    }

                    if (!visited[n-1][i] && (map[n-1][i] == '.' || keys.contains(Character.toLowerCase(map[n-1][i])) || map[n-1][i] >= 97 || map[n-1][i] == '$')) {
                        if (map[n-1][i] == '$') {
                            count ++;
                            map[n-1][i] = '.';
                        }
                        if (map[n-1][i] >= 97) {
                            keys.add(map[n-1][i]);
                            map[n-1][i] = '.';
                        }
                        bfs(n-1,i);
                    }
                }

                for (int i = 0 ; i < n ; i ++) {
                    // 외벽 세로줄 (방문한 적 없고, 벽이 아니고, 열 수 있는 문이거나 열쇠면)
                    if (!visited[i][0] && (map[i][0] == '.' || keys.contains(Character.toLowerCase(map[i][0])) || map[i][0] >= 97 || map[i][0] == '$')) {
                        if (map[i][0] == '$') {
                            count ++;
                            map[i][0] = '.';
                        }
                        if (map[i][0] >= 97) {
                            keys.add(map[i][0]);
                            map[i][0] = '.';
                        }
                        bfs(i,0);
                    }

                    if (!visited[i][m-1] && (map[i][m-1] == '.' || keys.contains(Character.toLowerCase(map[i][m-1])) || map[i][m-1] >= 97 || map[i][m-1] == '$')) {
                        if (map[i][m-1] == '$') {
                            count ++;
                            map[i][m-1] = '.';
                        }
                        if (map[i][m-1] >= 97) {
                            keys.add(map[i][m-1]);
                            map[i][m-1] = '.';
                        }
                        bfs(i,m-1);
                    }
                }
            }

            System.out.println(count);

        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
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

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 다음 갈 곳이 벽이거나 방문한 곳이면
                if (map[nx][ny] == '*' || visited[nx][ny]) continue;

                // 다음 갈 곳이 문인데 , 열쇠가 있는 경우
                if ( (map[nx][ny] >= 65 && map[nx][ny] < 97) ) {
                    // 열쇠가 없을 경우
                    if (!keys.contains(Character.toLowerCase(map[nx][ny]))) continue;
                    // 열쇠가 있을 경우
                    else {
                        map[nx][ny] = '.';
                    }
                }

                // 다음 갈 곳이 열쇠인데 이전에 본 적 없던 열쇠인 경우 전체적인 탐색을 다시 해야함. (일단은 쭉 진행) (set은 add 할 때 없었으면 true, 있었으면 false를 리턴함)
                if (map[nx][ny] >= 97 && map[nx][ny] != '$') {
                    if (keys.add(map[nx][ny])) {
                        reBfs = true;
                    }
                    map[nx][ny] = '.'; // . 으로 바꿔줘서 다음에 다시 탐색되지 않게 하기
                }

                // 다음 갈 곳이 문서인 경우
                if (map[nx][ny] == '$') {
                    count ++;
                    map[nx][ny] = '.';
                }

                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}