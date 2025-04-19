import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Node[] classes;

    static class Node implements Comparable<Node>{
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        classes = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes[i] = new Node(start, end);
        }

        Arrays.sort(classes);
        pq.add(classes[0].end);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= classes[i].start) {
                pq.poll();
            }
            pq.offer(classes[i].end);
        }

        System.out.println(pq.size());
    }
}