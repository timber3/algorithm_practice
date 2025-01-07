import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] result;
    static ArrayList<Integer> arr;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int val = Integer.parseInt(st.nextToken());

            if (set.add(val)) {
                arr.add(val);
            }
        }

        result = new int[m];

        Collections.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int cur) {

        if (cur == m) {
            for (int i = 0 ; i < m ; i ++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < set.size() ; i ++) {
            result[cur] = arr.get(i);
            dfs(cur + 1);
        }
    }
}