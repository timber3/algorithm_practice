import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, l, count;
    static int[][] map;
    static boolean[] avail;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        avail = new boolean[n+n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        for (int i = 0 ; i < n+n ; i ++) {
            if (avail[i]) count++;
        }

        System.out.println(count);

    }

    static void solve() {
        // 우선 그냥 갈 수 있는지 확인하기
        // 가로줄
        for (int i = 0 ; i < n ; i ++) {
            boolean flag = true;
            int val = map[i][0];
            for (int j = 0 ; j < n ; j ++) {
                if (map[i][j] != val) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 가로 : i 부터
                avail[i] = true;
            }
        }

        // 세로줄
        for (int i = 0 ; i < n ; i ++) {
            boolean flag = true;
            int val = map[0][i];
            for (int j = 0 ; j < n ; j ++) {
                if (map[j][i] != val) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 세로 : n + i 번째 부터
                avail[n+i] = true;
            }
        }

        boolean[][] visited = new boolean[n][n];

        // 가로 확인
        for (int i = 0 ; i < n ; i ++) {
            boolean flag = true;

            if (!avail[i]) {
                loop: for (int j = 1 ; j < n ; j ++) {
                    // 다음 값이 더 큰데
                    if (map[i][j-1] < map[i][j]) {
                        // j 앞에 l 만큼의 경사로를 깔 수 있는지 확인
                        if (j >= l) {
                            for (int k = 1 ; k <= l ; k++) {
                                // 경사로를 깔 바닥이 들쭉 날쭉이면 못깜  혹은 이미 뭐가 깔려있으면 안됨
                                if (map[i][j] - map[i][j-k] != 1 || visited[i][j-k]) {
                                    flag = false;
                                    break loop;
                                }

                                visited[i][j-k] = true;
                            }
                        } else {
                            flag = false;
                            break loop;
                        }
                    }
                    // 다음 값이 더 작은데
                    else if (map[i][j-1] > map[i][j]) {
                        // j 부터 l 만큼의 경사로를 깔 수 있는지 확인
                        if (n - j >= l) {
                            for (int k = 0 ; k < l ; k++) {
                                // 경사로를 깔 바닥이 들쭉 날쭉이면 못깜  혹은 이미 뭐가 깔려있으면 안됨
                                if (map[i][j-1] - map[i][j+k] != 1 || visited[i][j+k]) {
                                    flag = false;
                                    break loop;
                                }

                                visited[i][j+k] = true;
                            }
                        } else {
                            flag = false;
                            break loop;
                        }
                    }
                }

                // 무사히 끝냈다면
                if (flag) {
                    avail[i] = true;
                }
            }
        }

        visited = new boolean[n][n];
        // 세로 확인
        for (int i = 0 ; i < n ; i ++) {
            boolean flag = true;

            if (!avail[n+i]) {
                loop: for (int j = 1 ; j < n ; j ++) {
                    // 다음 값이 더 큰데
                    if (map[j-1][i] < map[j][i]) {
                        // j 앞에 l 만큼의 경사로를 깔 수 있는지 확인
                        if (j >= l) {
                            for (int k = 1 ; k <= l ; k++) {
                                // 경사로를 깔 바닥이 들쭉 날쭉이면 못깜  혹은 이미 뭐가 깔려있으면 안됨
                                if (map[j][i] - map[j-k][i] != 1 || visited[j-k][i]) {
                                    flag = false;
                                    break loop;
                                }

                                visited[j-k][i] = true;
                            }
                        } else {
                            flag = false;
                            break loop;
                        }
                    }
                    // 다음 값이 더 작은데
                    else if (map[j-1][i] > map[j][i]) {
                        // j 부터 l 만큼의 경사로를 깔 수 있는지 확인
                        if (n - j >= l) {
                            for (int k = 0 ; k < l ; k++) {
                                // 경사로를 깔 바닥이 들쭉 날쭉이면 못깜  혹은 이미 뭐가 깔려있으면 안됨
                                if (map[j-1][i] - map[j+k][i] != 1 || visited[j+k][i]) {
                                    flag = false;
                                    break loop;
                                }

                                visited[j+k][i] = true;
                            }
                        } else {
                            flag = false;
                            break loop;
                        }
                    }
                }

                // 무사히 끝냈다면
                if (flag) {
                    avail[n+i] = true;
                }
            }
        }


    }
}