import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int A, B, C;
    static boolean[][][] visited;
    static TreeSet<Integer> result = new TreeSet<>();

    static class State {
        int a, b, c;

        State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];
        bfs();

        for (int v : result) {
            sb.append(v).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs() {
        ArrayDeque<State> q = new ArrayDeque<>();
        q.add(new State(0, 0, C));
        visited[0][0][C] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            // A가 0일 때 C의 값을 추가
            if (cur.a == 0) {
                result.add(cur.c);
            }

            // 1. A -> B
            if (cur.a > 0 && cur.b < B) {
                int amount = Math.min(cur.a, B - cur.b);
                int na = cur.a - amount;
                int nb = cur.b + amount;
                if (!visited[na][nb][cur.c]) {
                    visited[na][nb][cur.c] = true;
                    q.add(new State(na, nb, cur.c));
                }
            }

            // 2. A -> C
            if (cur.a > 0 && cur.c < C) {
                int amount = Math.min(cur.a, C - cur.c);
                int na = cur.a - amount;
                int nc = cur.c + amount;
                if (!visited[na][cur.b][nc]) {
                    visited[na][cur.b][nc] = true;
                    q.add(new State(na, cur.b, nc));
                }
            }

            // 3. B -> A
            if (cur.b > 0 && cur.a < A) {
                int amount = Math.min(cur.b, A - cur.a);
                int nb = cur.b - amount;
                int na = cur.a + amount;
                if (!visited[na][nb][cur.c]) {
                    visited[na][nb][cur.c] = true;
                    q.add(new State(na, nb, cur.c));
                }
            }

            // 4. B -> C
            if (cur.b > 0 && cur.c < C) {
                int amount = Math.min(cur.b, C - cur.c);
                int nb = cur.b - amount;
                int nc = cur.c + amount;
                if (!visited[cur.a][nb][nc]) {
                    visited[cur.a][nb][nc] = true;
                    q.add(new State(cur.a, nb, nc));
                }
            }

            // 5. C -> A
            if (cur.c > 0 && cur.a < A) {
                int amount = Math.min(cur.c, A - cur.a);
                int nc = cur.c - amount;
                int na = cur.a + amount;
                if (!visited[na][cur.b][nc]) {
                    visited[na][cur.b][nc] = true;
                    q.add(new State(na, cur.b, nc));
                }
            }

            // 6. C -> B
            if (cur.c > 0 && cur.b < B) {
                int amount = Math.min(cur.c, B - cur.b);
                int nc = cur.c - amount;
                int nb = cur.b + amount;
                if (!visited[cur.a][nb][nc]) {
                    visited[cur.a][nb][nc] = true;
                    q.add(new State(cur.a, nb, nc));
                }
            }
        }
    }
}