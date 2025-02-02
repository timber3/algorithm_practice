import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;
    static long result;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < 10 ; i ++) {
            dfs(i, 1);
        }

        Collections.sort(list);

        if (n > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n-1));
        }

    }

    //9876543210  =>  10자리
    static void dfs(long num, int depth) {
        if (depth > 10) {
            return;
        }

        list.add(num);

        for (int i = 0 ; i < num % 10 ; i ++) {
            dfs((num * 10) + i, depth + 1);
        }

    }

}