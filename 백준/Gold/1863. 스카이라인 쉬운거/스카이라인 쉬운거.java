import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, cnt;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dq = new ArrayDeque<>();

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y == 0) {
                while(!dq.isEmpty()) {
                    dq.poll();
                    cnt ++;
                }
            } else {
                while (!dq.isEmpty() && dq.peekLast() > y) {
                    dq.pollLast();
                    cnt++;
                }
                if (dq.isEmpty() || dq.peekLast() < y) {
                    dq.add(y);
                }
                // 다음거가 높이가 같으면 추가 x
            }
        }

        while(!dq.isEmpty()) {
            dq.poll();
            cnt ++;
        }

        System.out.println(cnt);
    }
}