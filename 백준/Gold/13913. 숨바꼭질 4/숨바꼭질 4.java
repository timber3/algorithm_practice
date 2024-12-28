import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static int[] map;
    static int[] route;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[200_001];
        route = new int[200_001];

        Arrays.fill(map, -1);

        bfs(n);

        System.out.println(map[k]);

        int cur = route[k];

        ArrayDeque<Integer> result = new ArrayDeque<>();

        result.add(k);

        // 같은 위치에 있으면 반복할 필요 없음
        if (n != k) {
            while (cur != n) {
                result.add(cur);
                cur = route[cur];
            }

            result.add(n);
        }

        int size = result.size();

        for (int i = 0 ; i < size ; i ++) {
            sb.append(result.pollLast()).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    static void bfs(int n) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));

        // 걸린 시간
        map[n] = 0;
        route[n] = n;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cpos = cur.pos;
            int ctime = cur.time;

            // 순간이동
            if (2 * cpos <= 100_000 && map[2*cpos] == -1) {
                map[2*cpos] = ctime + 1;
                q.add(new Node(2 * cpos, ctime + 1));
                route[2*cpos] = cpos;
            }

            // + 1칸
            if (cpos + 1 <= 100_000 && map[cpos+1] == -1) {
                map[cpos+1] = ctime + 1;
                q.add(new Node(cpos + 1 , ctime + 1));
                route[cpos + 1] = cpos;
            }

            // - 1칸
            if (cpos - 1 >= 0 && map[cpos-1] == -1) {
                map[cpos-1] = ctime + 1;
                q.add(new Node(cpos -1 , ctime + 1));
                route[cpos - 1] = cpos;
            }
        }
    }

}