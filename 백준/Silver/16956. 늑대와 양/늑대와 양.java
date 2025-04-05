import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static char[][] map;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1, -1, 0, 0};

    static int result = 1;

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

        loop: for (int i = 0 ; i < n ; i ++ ) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] == 'S') {
                    for (int k = 0 ; k < 4 ; k ++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;

                        if (map[nx][ny] == 'W') {
                            result = 0;
                            break loop;
                        }

                        if (map[nx][ny] == '.')
                            map[nx][ny] = 'D';
                    }
                }
            }
        }

        if (result == 1) {
            sb.append(result).append('\n');
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < m ; j ++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }


}
