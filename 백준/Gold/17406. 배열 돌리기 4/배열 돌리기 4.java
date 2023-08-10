import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k, Min = Integer.MAX_VALUE;
    static int[][] Map, originMap;
    static int[] r, c, s, counter;
    static boolean[] visited;

    static int rotate() {

        // 배열 원본 넣어주기
        for (int i = 0 ; i < n ; i ++)
            Map[i] = Arrays.copyOfRange(originMap[i], 0, m);

        // 만든 순열 순서대로 돌리기
        for (int i = 0; i < k; i++) {
            int x = r[counter[i]] - 1;
            int y = c[counter[i]] - 1;
            int d = s[counter[i]];

            for (int j = 1 ; j <= d ; j ++) {

                // 왼쪽 위 값을 저장해주고 나중에 넣어주기
                int temp = Map[x-j][y-j];
                // 왼쪽 값 옮기기
                for (int t = x - j ; t < x + j ; t++) {
                    Map[t][y - j] = Map[t + 1][y - j];
                }
                // 밑에 값 옮기기
                for (int t = y - j ; t < y + j ; t++){
                    Map[x+j][t] = Map[x+j][t+1];
                }
                // 으른쪽 값 옮기기
                for (int t = x + j ; t > x - j ; t--){
                    Map[t][y + j] = Map[t-1][y + j];
                }
                // 위에 값 옮기기
                for (int t = y + j ; t > y - j + 1 ; t--){
                    Map[x-j][t] = Map[x-j][t-1];
                }
                Map[x-j][y-j+1] = temp;
            }
        }
        

        int result = Integer.MAX_VALUE;

        // 결과 배열 행 최솟값 계산하기
        for (int i = 0 ; i < n ; i ++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += Map[i][j];
            }
            result = Math.min(result, sum);
        }

        return result;
    }


    // 배열의 값 = 한 행의 합 중 최솟값
    static void permutation(int cnt) {
        if (cnt == k) {
            // 배열 돌리기~
            int result = rotate();
            Min = Math.min(Min, result);

            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                counter[cnt] = i;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Map = new int[n][m];
        originMap = new int[n][m];
        visited = new boolean[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        r = new int[k];
        c = new int[k];
        s = new int[k];
        counter = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(Min);
    }
}
