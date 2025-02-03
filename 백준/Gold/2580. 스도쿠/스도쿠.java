import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    static ArrayList<Node> zeros = new ArrayList<>();
    static boolean flag;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        map = new int[9][9];

        for (int i = 0 ; i < 9 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 9 ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeros.add(new Node(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {

        if (depth == zeros.size()) {
            for (int i = 0 ; i < 9 ; i ++) {
                for (int j = 0 ; j < 9 ; j ++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            flag = true;
            return;
        }

        Node cur = zeros.get(depth);

        for (int i = 1 ; i <= 9 ; i ++) {
            if (checkNum(cur.x, cur.y, i)) {
                map[cur.x][cur.y] = i;
                dfs(depth + 1);
                if (flag) return;
                map[cur.x][cur.y] = 0;
            }
        }
    }

    static boolean checkNum(int x, int y, int num) {
        boolean[] chk = new boolean[10];
        // 가로
        for (int i = 0 ; i < 9 ; i ++) {
            chk[map[x][i]] = true;
        }
        if (chk[num]) return false;

        chk = new boolean[10];
        // 세로
        for (int i = 0 ; i < 9 ; i ++) {
            chk[map[i][y]] = true;
        }
        if (chk[num]) return false;

        // x = 0 => 1
        // x = 1 => 4
        // x = 2 => 7

        chk = new boolean[10];
        // 속한 네모 확인
        int centerX = (x / 3) * 3 + 1;
        int centerY = (y / 3) * 3 + 1;
        
        chk[map[centerX][centerY]] = true;

        for (int i = 0 ; i < 8 ; i ++) {
            int nx = centerX + dx[i];
            int ny = centerY + dy[i];

            chk[map[nx][ny]] = true;
        }
        if (chk[num]) return false;

        return true;
    }
}