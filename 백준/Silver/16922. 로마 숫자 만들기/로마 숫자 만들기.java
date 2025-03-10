import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;
    static int[] value;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        value = new int[4];
        visited = new boolean[1001];

        value[0] = 1;
        value[1] = 5;
        value[2] = 10;
        value[3] = 50;

        dfs(0, 0, 0);

        System.out.println(count);
    }

    static void dfs(int depth, int idx, int sum) {
        if (depth == n) {
            if (!visited[sum]){
                visited[sum] = true;
                count ++;
            }
            return;
        }

        for (int i = idx ; i < 4 ; i ++) {
            dfs(depth + 1, i, sum + value[i]);
        }
    }
}