import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, tg, ts ,tb;

    static PriorityQueue<Medal> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1.g != o2.g) {
                    return o2.g - o1.g;
                } else if (o1.s != o2.s) {
                    return o2.s - o1.s;
                } else {
                    return o2.b - o1.b;
                }
            }
    );

    static class Medal {
        int g, s, b;

        public Medal(int g, int s, int b) {
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Medal(g, s, b));

            if (no == k) {
                tg = g;
                ts = s;
                tb = b;
            }
        }

        int count = 0;
        while(!pq.isEmpty()) {
            count ++;
            Medal cur = pq.poll();
            if (cur.g == tg && cur.s == ts && cur.b == tb) break;
        }
        System.out.println(count);

    }
}
