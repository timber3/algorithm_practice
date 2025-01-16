import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // 동, 북, 서, 남
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            directions = new ArrayList<>();
            directions.add(d);

            for (int j = 1; j <= g; j++) {
                int size = directions.size();
                for (int k = size - 1; k >= 0; k--) {
                    directions.add((directions.get(k) + 1) % 4);
                }
            }

            map[y][x] = true;
            for (int dir : directions) {
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                    map[y][x] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}