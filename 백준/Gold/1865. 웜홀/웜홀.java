import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int TC, n, m, w;
    static int[][] map;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        TC = Integer.parseInt(br.readLine());

        loop: for (int tc = 0 ; tc < TC ; tc ++) {

            st = new StringTokenizer(br.readLine());
            // 1 ~ 500
            n = Integer.parseInt(st.nextToken());
            // 1 ~ 2500
            m = Integer.parseInt(st.nextToken());
            // 1 ~ 200
            w = Integer.parseInt(st.nextToken());

            map = new int[n+1][n+1];

            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j ++) {
                    // 시간이 -10000 ~ 10000 까지 가능하기 때문에
                    map[i][j] = MAX;
                }
            }

            // tq 도로는 방향이 없었네
            for (int i = 0 ; i < m ; i ++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());


                if (map[s][e] == MAX || map[s][e] > t) {
                    map[s][e] = t;
                    map[e][s] = t;
                }
            }

            // 방향이 있음
            // tq 심지어 제자리로 연결되는 웜홀도 있음 ;;
            for (int i = 0 ; i < w ; i ++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[s][e] = -1 * t;
            }

            // floyd
            for (int k = 1 ; k <= n ; k ++) {
                for (int i = 1 ; i <= n ; i ++) {
                    for (int j = 1 ; j <= n ; j ++) {

//                        if (i == k || j == k)
//                            continue;

                        if (map[i][k] == MAX || map[k][j] == MAX)
                            continue;

                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }

                        if (i == j && map[i][j] < 0) {
                            System.out.println("YES");
                            continue loop;
                        }
                    }
                }
            }

            // 갔다가 왔을 때 -인 경우 찾기
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j ++) {
                    if (map[i][j] == MAX || map[j][i] == MAX)
                        continue;

                    if (map[i][j] + map[j][i] < 0) {
                        System.out.println("YES");
                        continue loop;
                    }
                }
            }
            System.out.println("NO");
        }
    }
}