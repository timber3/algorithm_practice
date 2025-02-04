import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, max = Integer.MIN_VALUE;
    static boolean[] taught = new boolean[27];
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        taught['a' - 'a'] = true;
        taught['n' - 'a'] = true;
        taught['t' - 'a'] = true;
        taught['i' - 'a'] = true;
        taught['c' - 'a'] = true;

        k -= 5;

        // a n t i c 은 무조건 가르쳐야 함.
        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            String target = str.substring(4, str.length() - 4);
            list.add(target);
        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int depth, int idx) {
        if (depth == k) {
            // 읽을 수 있는 문자가 몇개인지 확인
            int count = 0;
            for (String str : list) {
                boolean flag = false;
                for (int i = 0 ; i < str.length() ; i++) {
                    if (!taught[str.charAt(i) - 'a']) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) count ++;
            }
            if (count > max) max = count;
            return;
        }

        for (int i = idx; i <= 26 ; i ++) {
            if (!taught[i]) {
                taught[i] = true;
                dfs(depth + 1, i + 1);
                taught[i] = false;
            }
        }
    }
}