import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static boolean[] broken;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        // 수빈이가 보고있는 채널은 100
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        dist = new int[1000001];

        for (int i = 0 ; i <= 1000000 ; i ++) {
            dist[i] = -1;
        }

        if (m != 0)
            st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < m ; i ++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        bfs();

        System.out.println(dist[n]);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        loop: for (int i = 0 ; i <= 1000000 ; i ++) {
            // 각 자리와 자릿수를 구해서 해당 숫자가 만들어 질 수 있는 숫자인지 확인
            String iStr = i + "";

            for (int j = 0; j < iStr.length(); j++) {
                // 만약 구성하는 숫자의 버튼을 사용할 수 없다면
                if (broken[iStr.charAt(j) - '0']) {
                    continue loop;
                }
            }
            dist[i] = iStr.length();
            q.add(i);
        }
        q.add(100);
        dist[100] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur - 1 >= 0 && (dist[cur - 1] == -1 || dist[cur - 1] > dist[cur] + 1)) {
                q.add(cur - 1);
                dist[cur-1] = dist[cur] + 1;
            }

            if (cur + 1 <= 1000000 && (dist[cur + 1] == -1 || dist[cur + 1] > dist[cur] + 1)) {
                q.add(cur + 1);
                dist[cur + 1] = dist[cur] + 1;
            }
        }

    }
}