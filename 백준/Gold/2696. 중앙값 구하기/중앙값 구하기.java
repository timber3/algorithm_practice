import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, n, count;
    static PriorityQueue<Integer> maxPQ;
    static PriorityQueue<Integer> minPQ;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++ ) {

            count = 0;
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            maxPQ = new PriorityQueue<>(
                    (o1, o2) -> {
                        return o2-o1;
                    }
            );
            minPQ = new PriorityQueue<>();
            if (n % 2 == 0) {
                sb.append(n/2).append('\n');
            } else {
                sb.append(n/2 + 1).append('\n');
            }

            for (int i = 0 ; i < n ; i ++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int value = Integer.parseInt(st.nextToken());

                if (maxPQ.isEmpty() || value <= maxPQ.peek()) {
                    maxPQ.add(value);
                } else {
                    minPQ.add(value);
                }

                if (maxPQ.size() > minPQ.size() + 1) {
                    minPQ.add(maxPQ.poll());
                } else if (minPQ.size() > maxPQ.size()){
                    maxPQ.add(minPQ.poll());
                }
                if (count == 10) {
                    sb.append('\n');
                    count = 0;
                }
                if (i % 2 == 0) {
                    sb.append(maxPQ.peek()).append(" ");
                    count ++;
                }
            }
            sb.append('\n');
            System.out.print(sb);
        }
    }
}