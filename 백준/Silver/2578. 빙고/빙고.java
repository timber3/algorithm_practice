import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        map = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0 ; i < 5 ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < 5 ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < 5 ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ;  j++) {
                int next = Integer.parseInt(st.nextToken());
                count ++;
                if (chkNum(next)) {
                    System.out.println(count);
                    return;
                }

            }
        }
    }

    static boolean chkNum(int next) {
        loop: for (int i = 0 ; i < 5 ; i ++ ){
            for (int j = 0 ; j < 5 ; j ++) {
                if (map[i][j] == next) {
                    visited[i][j] = true;
                    break loop;
                }
            }
        }

        int line = 0;

        for (int i = 0 ; i < 5 ; i ++) {
            boolean full = true;
            for (int j = 0 ; j < 5 ; j ++) {
                if (!visited[i][j]) full = false;
            }

            if (full) {
                line ++;
            }
        }

        for (int j = 0 ; j < 5 ; j ++) {
            boolean full = true;
            for (int i = 0 ; i < 5 ; i ++) {
                if (!visited[i][j]) full = false;
            }

            if (full) {
                line ++;
            }
        }

        if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4] ) line ++;

        if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0] ) line ++;

        if (line >= 3) return true;
        else return false;
    }
}