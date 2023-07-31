import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int Map[][] = new int[19][19];
    static int dx[] = {-1, 0, 1, 1};
    static int dy[] = {1, 1, 1, 0};

    static boolean cal(int x, int y)  {

        int color = Map[x][y];

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int cx = x;
            int cy = y;

            int cnt = 0;

            // 한 방향으로 현재 위치부터 5개 더 추가 확인
            for (int k = 0; k < 5; k++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19
                        || Map[nx][ny] != color) {
                    break;
                }

                cnt ++;
                cx = nx;
                cy = ny;
            }

            // 만약 5목을 찾았다면 6목인지 확인
            if (cnt == 4)
            {
                int bx = x - dx[i];
                int by = y - dy[i];

                if (bx < 0 || by < 0 || bx >= 19 || by >= 19
                || Map[bx][by] != color) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {


        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (Map[i][j] != 0) {

                    boolean result = cal(i,j);

                    if (result) {
                        if (Map[i][j] == 1) {
                            System.out.println(1);
                            System.out.println((i+1) + " " + (j + 1));
                            return;
                        }
                        else if (Map[i][j] == 2) {
                            System.out.println(2);
                            System.out.println((i+1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }
}
