import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k, m;
    static ArrayList<Integer>[] map;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 모든 역 + 하이퍼튜브 ( 해당 하이퍼튜브 안에는 어떤 역들이 있는지 나타냄 )
        // 중복된 역이 들어가는걸 방지하기 위해 set으로 선언
        map = new ArrayList[n + m + 1];
        visited = new int[n + m + 1];

        for (int i = 1; i <= n + m ; i++) {
            map[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 1 ; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());
            // 하이퍼튜브는 n+1번부터 시작
            int hyperTube = n + i;

            for (int j = 0; j < k; j++) {
                int station = Integer.parseInt(st.nextToken());
                map[station].add(hyperTube);
                map[hyperTube].add(station);
            }
        }

        bfs();

        System.out.println(visited[n]);
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[1] = 1;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : map[cur]) {
                if (visited[next] == -1) {
                    // 역을 방문할 때 만 +1 해주기
                    if (next <= n) {
                        visited[next] = visited[cur] + 1;
                    } else {
                        visited[next] = visited[cur];
                    }
                    q.add(next);
                }
            }
        }
    }
}