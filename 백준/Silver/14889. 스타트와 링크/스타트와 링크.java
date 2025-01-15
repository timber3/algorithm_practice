import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] team;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        team = new boolean[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int idx) {
        if (depth == n/2) {
            int team1 = 0;
            int team2 = 0;

            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if (team[i] && team[j]) {
                        team1 += map[i][j];
                    } else if (!team[i] && !team[j]){
                        team2 += map[i][j];
                    }
                }
            }

            if (min > Math.abs(team1 - team2)) {
                min = Math.abs(team1 - team2);
            }

            return;
        }

        for (int i = idx ; i < n ; i ++) {
            if (!team[i]) {
                team[i] = true;
                dfs(depth + 1, i);
                team[i] = false;
            }
        }
    }
}