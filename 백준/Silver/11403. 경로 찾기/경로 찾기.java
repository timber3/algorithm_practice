import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    
    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fw();

        for (int i = 0; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fw() {
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                for (int k = 0 ; k < n ; k ++) {

                    if (map[j][i] == 1 && map[i][k] == 1) {
                        map[j][k] = 1;
                    }
                }
            }
        }
    }

}