import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
    );

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int next = Integer.parseInt(br.readLine());

            if (next != 0)
                pq.add(next);
            else {
                if (!pq.isEmpty())
                    sb.append(pq.poll()).append('\n');
                else
                    sb.append(0).append('\n');
            }
        }

        System.out.println(sb);

    }
}