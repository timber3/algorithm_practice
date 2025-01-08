import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, max;
    static int[][] map;
    static ArrayList<Node> avail = new ArrayList<>();
    static boolean[] rightDown, rightUp;
    static boolean[] used;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        rightDown = new boolean[2*n]; // n + x - y
        rightUp = new boolean[2*n]; // x + y + 1

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    avail.add(new Node(i,j));
                }
            }
        }

        used = new boolean[avail.size()];

        dfs(0,0,0);
        int black = max;
        max = 0;
        dfs(0,0,1);
        int white = max;

        System.out.println(black + white);
    }

    static void dfs(int cur, int idx, int color) {

        if (cur > max) {
            max = cur;
        }

        for (int i = idx ; i < avail.size(); i++) {
            if (!used[i]) {
                Node temp = avail.get(i);
                int x = temp.x;
                int y = temp.y;

                // 같은 색깔만 확인하기
                if ((x + y) % 2 == color) {
                    if (canPut(x,y)) {
                        used[i] = true;
                        // 헤도 놓기
                        rightUp[x + y + 1] = true;
                        rightDown[n + x - y] = true;
                        dfs(cur + 1, i, color);
                        // 헤도 빼기
                        used[i] = false;
                        rightUp[x + y + 1] = false;
                        rightDown[n + x - y] = false;
                    }
                }

            }
        }
    }

    static boolean canPut(int x, int y) {
        // 대각선 확인
        if (rightUp[x + y + 1] || rightDown[n + x - y]) return false;

        return true;
    }
}