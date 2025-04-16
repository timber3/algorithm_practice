import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, sum, curMin, curMax;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.x == o2.x) {
            return o1.y - o2.y;
        } else {
            return o1.x - o2.x;
        }
    });


    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Node(x, y));
        }

        curMin = pq.peek().x;
        curMax = pq.peek().y;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int cx = cur.x;
            int cy = cur.y;

            // 다음 시작하는 부분이 이전에 속한다면 이전 선에 나머지 부분을 붙이기
            if (curMin <= cx && cx <= curMax) {
                if (curMax < cy) curMax = cy;
            }
            // 다음 시작하는 부분이 이전 줄에 속하지 않으면 별개의 선임
            // 그래서 이전 선의 길이를 더해주고 다음 선으로 넘어가기
            else {
                sum += (curMax - curMin);
                curMin = cx;
                curMax = cy;
            }
        }

        sum += curMax - curMin;

        System.out.println(sum);
    }
}