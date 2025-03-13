import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o2 - o1;
            }
    );

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            result = pq.poll();
        }

        System.out.println(result);
    }
}