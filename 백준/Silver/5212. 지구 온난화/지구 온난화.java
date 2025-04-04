import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static char[][] map;
    static boolean[][] remove;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        remove = new boolean[n][m];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();

            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] == 'X') {

                    int count = 0;

                    for (int k = 0 ; k < 4 ; k ++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            count ++;
                            continue;
                        }
                        if (map[nx][ny] == '.') count ++;
                    }

                    if (count >= 3) {
                        remove[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (remove[i][j]) {
                    map[i][j] = '.';
                }
            }
        }

        int minRow = n, maxRow = 0, minCol = m, maxCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
