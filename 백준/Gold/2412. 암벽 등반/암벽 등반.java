import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, t, min = Integer.MAX_VALUE;
    static ArrayList<Node>[] list;
    static int[] dd = {-2, -1, 0, 1, 2};

    static class Node {
        int x;
        int y;
        int visited;

        public Node(int x, int y, int visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new ArrayList[t+1];

        for (int i = 0 ; i < t + 1 ; i ++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[y].add(new Node(x, y, -1));
        }

        bfs();

        for (Node cur : list[t]) {
            if (min > cur.visited && cur.visited != -1) min = cur.visited;
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {

            Node cur = q.poll();

            int cx = cur.x;
            int cy = cur.y;
            int cv = cur.visited;

            for (int i = 0 ; i < 5 ; i ++) {
                int ny = cy + dd[i];

                if (ny < 0 || ny > t) continue;

                for (Node next : list[ny]) {
                    if (next.visited != -1) continue;

                    int nx = next.x;

                    if (Math.abs(cx - nx) > 2 || Math.abs(cy - ny) > 2 ) continue;

                    q.add(new Node(nx, ny, cv + 1));
                    next.visited = cv + 1;
                }
            }
        }
    }
}