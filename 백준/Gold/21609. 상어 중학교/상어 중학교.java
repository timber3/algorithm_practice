import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int n, m, sx, sy, max, result, rainMax;
    static int[][] map;
    static boolean[][] visited, bigBlock;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        bigBlock = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            max = 0;
            rainMax = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= 1) {
                        bfs(i, j, map[i][j]);
                    }
                }
            }

            // 만약 블럭이 없으면 종료 해야함.
            // 블럭 그룹이 있다면
            if (max >= 2) {
                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // 가장 큰 그룹
                        if (bigBlock[i][j]) {
                            map[i][j] = -2;
                            count++;
                        }
                    }
                }


                result += (int) Math.pow(count, 2);

                gravity();
                rotate();
                gravity();

            } else
                break;
        }
        System.out.println(result);
    }

    // 일단 블럭을 찾는다.
    static void bfs(int x, int y, int cur) {
        visited = new boolean[n][n];
        Queue<Node> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new Node(x, y));

        int count = 1;
        int rainCount = 0;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 밖으로 나갔다면 || 이미 방문한 곳이라면 || 검은색 블럭이라면
                if (!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }

                if (map[nx][ny] == cur || map[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                    if (map[nx][ny] == 0)
                        rainCount++;
                }
            }
        }

        // 찾은 블럭의 크기가 최대값보다 크면
        if (count > max) {
            // 최대값 갱신
            max = count;
            rainMax = rainCount;
            boolean flag = false;
            // 기준 블럭 갱신
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 가장 큰 블럭 기록 해두기
                    bigBlock[i][j] = visited[i][j];

                    // 방문한 곳이면서, 해당 좌표가 색깔 블럭일 경우 기준 블럭을 교체해준다.
                    if (visited[i][j] && map[i][j] >= 1 && !flag) {
                        sx = i;
                        sy = j;
                        flag = true;
                    }
                }
            }
        }
        // 현재 찾은 블럭이 가장 큰 블럭이랑 갯수가 같으면
        // 기존의 max 블럭과 기준 블럭의 좌표를 비교해서 갱신해준다.
        if (count == max) {
            int cur_sx = -1;
            int cur_sy = -1;

            loop:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 기준 블럭을 비교하기 위해 기준 블록을 찾아준다.
                    if (visited[i][j] && map[i][j] >= 1) {
                        cur_sx = i;
                        cur_sy = j;
                        break loop;
                    }
                }
            }

            if (rainCount > rainMax) {
                rainMax = rainCount;
                sx = cur_sx;
                sy = cur_sy;

                // 가장 큰 블럭이 바뀌었으므로 다시 지정해주기.
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        bigBlock[i][j] = visited[i][j];
                    }
                }
            }

            // 블럭의 크기가 같으면서 rainCount 도 같으면
            if (rainCount == rainMax) {
                // 행, 열 순으로 큰 값을 대입함.
                if (cur_sx > sx) {
                    sx = cur_sx;
                    sy = cur_sy;
                    // 가장 큰 블럭이 바뀌었으므로 다시 지정해주기.
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            bigBlock[i][j] = visited[i][j];
                        }
                    }
                } else if (cur_sx == sx) {
                    if (cur_sy > sy) {
                        sy = cur_sy;
                        // 가장 큰 블럭이 바뀌었으므로 다시 지정해주기.
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                bigBlock[i][j] = visited[i][j];
                            }
                        }
                    }
                }

            }
        }
    }

    static void rotate() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - j - 1][i] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    static void gravity() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 공백을 찾았으면 위로 올라가면서 블럭과 위치를 바꾼다.
                if (map[i][j] == -2) {
                    // 현재 높이를 저장.
                    int index = i;

                    while (index != 0) {
                        index--;

                        if (map[index][j] == -1) {
                            break;
                        } else if (map[index][j] >= 0) {
                            // 위치 바꿔주기
                            int t = map[i][j];
                            map[i][j] = map[index][j];
                            map[index][j] = t;
                            break;
                        }
                    }
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return !(x < 0 || y < 0 || x >= n || y >= n);
    }
}