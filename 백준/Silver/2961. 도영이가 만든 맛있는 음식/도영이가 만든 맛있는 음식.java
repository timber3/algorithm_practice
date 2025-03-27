import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, min = Integer.MAX_VALUE;
    static int[][] ingredient;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        ingredient = new int[n][2];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int sumS, int sumB) {

        if (depth == n) {
            if (sumS == 1 && sumB == 0) {
                return;
            } else {
                int diff = Math.abs(sumS - sumB);
                if (min > diff) min = diff;
            }
            return;
        }

        // 쓰기
        dfs(depth+1, sumS * ingredient[depth][0], sumB + ingredient[depth][1]);

        // 안쓰기
        dfs(depth + 1, sumS, sumB);
    }
}
