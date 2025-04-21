import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k, count;
    static String num;
    static ArrayDeque<Character> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = br.readLine();

        for (int i = 0 ; i < n ; i ++) {
            char cur = num.charAt(i);

            while(!q.isEmpty() && count < k && q.peekLast() < cur) {
                q.pollLast();
                count ++;
            }

            q.add(cur);
        }

        while (count < k) {
            q.pollLast();
            count++;
        }

        for (char c : q) {
            sb.append(c);
        }

        System.out.println(sb);

    }
}