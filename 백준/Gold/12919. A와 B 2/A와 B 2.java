import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;

    static int n, result;
    static String s, t;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        t = br.readLine();

        n = t.length() - s.length();

        dfs(t);

        System.out.println(result);
    }

    // 거꾸로 원복하면서 만들어지는지 확인하면 된다.
    static void dfs(String cur) {
        if (cur.length() == s.length()) {
            if (cur.equals(s)) result = 1;
            return;
        }

        if (result == 1) return;

        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }

        if (cur.charAt(0) == 'B') {
            sb = new StringBuilder(cur.substring(1, cur.length()));
            cur = sb.reverse().toString();
            dfs(cur);
        }
    }
}
