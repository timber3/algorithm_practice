import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Lecture[] lectures;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static class Lecture {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        lectures = new Lecture[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });

        // pq에 첫번째 강의 끝나는 시간 넣기
        pq.add(lectures[0].end);

        for (int i = 1 ; i < n ; i ++) {
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.add(lectures[i].end);
        }

        System.out.println(pq.size());

    }
}