import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int f,s,g,u,d;
    static int[] map;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 층수
        s = Integer.parseInt(st.nextToken()); // 현재 위치
        g = Integer.parseInt(st.nextToken()); // 목표 위치
        u = Integer.parseInt(st.nextToken()); // 위로 몇층
        d = Integer.parseInt(st.nextToken()); // 아래로 몇층

        map = new int[f+1];

        Arrays.fill(map, -1);

        bfs();

        if (map[g] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(map[g]);
        }
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(s);
        map[s] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur + u <= f && map[cur + u] == -1) {
                q.add(cur + u);
                map[cur + u] = map[cur] + 1;
            }

            if (cur - d >= 1 && map[cur - d] == -1) {
                q.add(cur - d);
                map[cur - d] = map[cur] + 1;
            }
        }
    }
}