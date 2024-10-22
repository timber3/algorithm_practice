import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int n;

    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = 999;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (from == -1 && to == -1) {
                break;
            }

            map[from][to] = 1;
            map[to][from] = 1;

        }

        fw();


        int min = 9999;

        for (int i = 1 ; i <= n ; i ++) {
            int max = 0;

            for (int j = 1 ; j <= n ; j ++) {
               if (max < map[i][j])
                   max = map[i][j];
            }

            if (max <= min) {
                if (max < min) list = new ArrayList<>();
                list.add(i);
                min = max;
            }
        }

        System.out.println(min + " " + list.size());

        for(int i : list) {
            System.out.print(i + " ");
        }

    }

    public static void fw() {

        // 거쳐가는 노드는 k
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}