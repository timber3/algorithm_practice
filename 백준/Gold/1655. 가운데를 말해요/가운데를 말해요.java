import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int val = Integer.parseInt(br.readLine());

            // maxPq는 중간 값 보다 작거나 같은 값들을 담는다. (그 중에서 가장 큰 값을 뽑기 위해서)
            if (maxPq.isEmpty() || val <= maxPq.peek()) {
                maxPq.add(val);
            }
            // minPq는 중간 값 보다 큰 값들을 담는다. (그 중에서 가장 작은 값을 뽑기 위해서)
            else {
                minPq.add(val);
            }

            // 좌 우 개수 맞춰서 가운데 값 찾기
            if (maxPq.size() > minPq.size() + 1) {
                minPq.add(maxPq.poll());
            } else if (maxPq.size() < minPq.size()) {
                maxPq.add(minPq.poll());
            }

            sb.append(maxPq.peek()).append('\n');
        }
        
        System.out.println(sb);
    }
}