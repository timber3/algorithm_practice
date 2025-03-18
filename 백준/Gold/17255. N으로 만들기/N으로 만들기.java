import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashSet<String> set = new HashSet<>();
    static String N;

    public static void main(String[] args) throws Exception {
        N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            String num = N.substring(i, i + 1);
            String path = num;
            dfs(i, i, num, path);
        }

        System.out.println(set.size());
    }

    static void dfs(int left, int right, String current, String path) {
        if (current.equals(N)) {
            set.add(path);
            return;
        }

        if (left - 1 >= 0) {
            String next = N.substring(left - 1, right + 1);
            dfs(left - 1, right, next, path + next);
        }
        if (right + 1 < N.length()) {
            String next = N.substring(left, right + 2);
            dfs(left, right + 1, next, path + next);
        }
    }
}