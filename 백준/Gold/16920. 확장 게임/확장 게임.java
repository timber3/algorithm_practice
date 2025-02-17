import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, p, zero;
    static int[] move, count;
    static char[][] map;
    static ArrayDeque<Node>[] queues;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        move = new int[p+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= p ; i ++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        queues = new ArrayDeque[p+1];

        for (int i = 1 ; i <= p ; i ++) {
            queues[i] = new ArrayDeque<>();
        }

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '.') zero ++;
                if (map[i][j] != '#' && map[i][j] != '.') {
                    int player = map[i][j] - '0';
                    queues[player].add(new Node(i,j,0));
                }
            }
        }

        while(true) {
            int curZero = zero;
            bfs();
            if (curZero == zero || zero == 0) break;
        }

        count = new int[p+1];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] != '#' && map[i][j] != '.') {
                    count[map[i][j] - '0'] ++;
                }
            }
        }

        for (int i = 1 ; i <= p ; i ++) {
            sb.append(count[i]).append(' ');
        }

        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;
        int mv;

        public Node(int x, int y, int mv) {
            this.x = x;
            this.y = y;
            this.mv = mv;
        }
    }

    static void bfs() {

        for (int t = 1 ; t <= p ; t ++) {
            ArrayDeque<Node> temp = new ArrayDeque<>();

            while(!queues[t].isEmpty()) {
                Node cur = queues[t].poll();

                int cx = cur.x;
                int cy = cur.y;
                int cmv = cur.mv;

                if (cmv == move[t]) continue;

                for (int i = 0 ; i < 4; i ++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != '.') continue;

                    temp.add(new Node(nx, ny, 0));
                    queues[t].add(new Node(nx, ny, cmv + 1));
                    map[nx][ny] = (char) (t + '0');
                    zero --;

                }
            }
            queues[t] = temp;
        }
    }
}