import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] population;
    static boolean[][] Map;
    static boolean[] selected, visited;
    static int result = Integer.MAX_VALUE;
    static int allSum;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        population = new int[n+1];
        Map = new boolean[n+1][n+1];
        selected = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            allSum += population[i];
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());

            for (int t = 0; t < T; t++) {
                int nx = Integer.parseInt(st.nextToken());
                Map[i][nx] = true;
                Map[nx][i] = true;
            }
        }

        dfs(1);

        if ( result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);

    }

    static void dfs(int cnt) {
        if (cnt == n+1) {
            // bfs 돌리기 전마다 visited 초기화를 해줘야 함.
            visited = new boolean[n+1];
            int area = 0;  // 나눠진 구역 갯수 세기용
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) { // 방문된 적 없다면 = 2번만에 다 되어야 함.
                    visited[i] = true;
                    bfs(i);
                    area ++;
                }
            }

            // 구역이 딱 2개로 나눠졌으면
            if (area == 2){
                int sum = 0;

                for (int i = 1; i <= n; i++) {
                    if(selected[i])
                        sum += population[i];
                }
                int rest = allSum - sum;
                result = Math.min(result, Math.abs(rest - sum));
            }
            return;
        }

        // 선택
        selected[cnt]  = true;
        dfs(cnt+1);
        selected[cnt] = false;

        // 비선택
        dfs(cnt+1);
    }

    static void bfs(int t) {
        // 선택된 정점들이 인접한지 + 구역이 2개로 나뉘었는지 확인
        Queue<Integer> q = new LinkedList<>();
        q.add(t);
        visited[t] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && Map[cur][i] && (selected[cur] == selected[i]) ) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
