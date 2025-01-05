import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, max;
    static int[] weight, durability;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        durability = new int[n];
        weight = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int cur) {
        if (cur == n) {
            int count = 0;
            // 깨진 계란 개수 세기
            for (int i = 0 ; i < n ; i ++) {
                if (durability[i] <= 0) count++;
            }
            if (count > max) {
                max = count;
            }
            return;
        }

        boolean hit = false;
        
        for (int i = 0 ; i < n ; i ++) {
            // 자기 스스로는 넘어가고
            // 현재 내구도가 0이상에 다음 칠 애 내구도가 0 이상이면 치낟.
            if (i != cur && durability[cur] > 0 && durability[i] > 0) {
                hit = true;
                durability[i] -= weight[cur];
                durability[cur] -= weight[i];
                dfs(cur + 1);
                durability[i] += weight[cur];
                durability[cur] += weight[i];
            }
        }

        if (!hit) dfs(cur + 1);
    }
}