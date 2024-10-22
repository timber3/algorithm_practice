import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int K, V, E;
    static ArrayList[] map;
    static int[] visited;

    public static void main(String[] args) throws Exception {

        K = Integer.parseInt(br.readLine());

        for (int k = 0 ; k < K ; k ++) {

            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            map = new ArrayList[V+1];

            for (int i = 0 ; i <= V ; i ++) {
                map[i] = new ArrayList<Integer>();
            }

            for (int i = 0 ; i < E ; i ++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                map[from].add(to);
                map[to].add(from);
            }
            // input
            visited = new int[V+1];

            boolean flag = true;

            for (int i = 1 ; i <= V ; i ++) {
                if (visited[i] == 0) {
                    if (!bfs(i)) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static boolean bfs(int t) {

        ArrayDeque<Node> q = new ArrayDeque<>();

        q.add(new Node(t, 1));
        visited[t] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int cno = cur.no;
            int cteam = cur.team;

            for (Object i : map[cno]) {
                int next = (Integer) i;

                if (cteam == visited[next]) {
                    return false;
                }

                if (visited[next] == 0) {
                    q.add(new Node(next, cteam * -1));
                    visited[next] = cteam * -1;
                }
            }
        }

        return true;
    }

    public static class Node {
        int no;
        int team;

        public Node(int no, int team) {
            this.no = no;
            this.team = team;
        }
    }

}