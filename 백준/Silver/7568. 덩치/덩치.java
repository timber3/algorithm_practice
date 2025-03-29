import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] arr;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        rank = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i ++) {

            int count = 0;

            for (int j = 0 ; j < n ; j ++) {
                if (i == j) continue;

                if (arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    count++;
                }
            }

            rank[i] = count;
        }

        for (int i = 0 ; i < n ; i ++) {
            sb.append(rank[i]+1).append(' ');
        }

        System.out.println(sb);

    }
}
