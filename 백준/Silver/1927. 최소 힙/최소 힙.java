import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (!pq.isEmpty())
                    sb.append(pq.poll()).append('\n');
                else
                    sb.append(0).append('\n');
            } else {
                pq.add(value);
            }
        }

        System.out.println(sb);
    }
}