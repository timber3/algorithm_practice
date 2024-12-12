import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int su, bro;
    static int[] visited, count;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        // 0 ~ 100,000
        su = Integer.parseInt(st.nextToken());
        // 0 ~ 100,000
        bro = Integer.parseInt(st.nextToken());

        // 걷기 : 1초후에 x-1 or x+1
        // 순간이동 : 1초후에 2*x

        visited = new int[200_001];
        count = new int[200_001];

        bfs();

        System.out.println(visited[bro] - 1);
        System.out.println(count[bro]);

    }

    static void bfs() {
        Arrays.fill(visited, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(su);
        visited[su] = 1;
        count[su] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            // 텔레포트
            if (cur <= 100_000) {
                if (visited[cur * 2] == -1 || visited[cur * 2] >= visited[cur] + 1) {
                    q.add(cur * 2);
                    visited[cur * 2] = visited[cur] + 1;

                    if (visited[cur * 2] > visited[cur] + 1) {
                        count[cur * 2] = 0;
                    }
                    count[cur * 2] ++;
                }
            }

            // 걷기
            if (cur - 1 >= 0) {
                if (visited[cur - 1] == -1 || visited[cur - 1] >= visited[cur] + 1) {
                    q.add(cur - 1);
                    visited[cur-1] = visited[cur] + 1;

                    if (visited[cur - 1] > visited[cur] + 1) {
                        count[cur-1] = 0;
                    }
                    count[cur-1] ++;
                }
            }

            if (cur + 1 <= 100_000) {
                if (visited[cur + 1] == -1 || visited[cur + 1] >= visited[cur] + 1) {
                    q.add(cur + 1);
                    visited[cur+1] = visited[cur] + 1;

                    if (visited[cur + 1] > visited[cur] + 1) {
                        count[cur+1] = 0;
                    }
                    count[cur+1] ++;
                }
            }
        }
    }
}