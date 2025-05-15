import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static long count;

    // 문자열 길이 : 등수
    static HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < n ; i ++) {

            String str = br.readLine();


            if (!map.containsKey(str.length())) {
                map.put(str.length(), new ArrayDeque<>());
            }

            ArrayDeque<Integer> cur = map.get(str.length());

            while(!cur.isEmpty() && i - cur.peek() > k) {
                cur.poll();
            }

            count += cur.size();
            cur.offer(i);

        }

        System.out.println(count);

    }
}