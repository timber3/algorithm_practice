import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int chuCount, beadCount;
    static int[] chuWeight, beadWeight;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        chuCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        chuWeight = new int[chuCount];

        for (int i = 0 ; i < chuCount ; i++) {
            chuWeight[i] = Integer.parseInt(st.nextToken());
        }

        beadCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        beadWeight = new int[beadCount];

        for (int i = 0 ; i < beadCount ; i++) {
            beadWeight[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[chuCount + 1][40001];

        dfs(0, 0);

        for (int i = 0 ; i < beadCount ; i++) {
            if (dp[chuCount][beadWeight[i]]) {
                sb.append('Y').append(' ');
            } else {
                sb.append('N').append(' ');
            }
        }

        System.out.println(sb);

    }

    public static void dfs(int depth, int sum) {
        if (dp[depth][sum]) return;
        dp[depth][sum] = true;
        if(depth == chuCount) return;

        dfs(depth + 1, sum); // 추 안올림
        dfs(depth + 1, sum + chuWeight[depth]); // 추 오른쪽에 올리기
        dfs(depth + 1, Math.abs(sum - chuWeight[depth])); // 추 왼쪽에
    }
}