import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static Point[] map;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new Point[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[i] = new Point(x, y);

        }

        long sum = 0;

        // 덧셈 부분
        for (int i = 1 ; i < n ; i ++) {
            sum += (long) map[i].x * map[i+1].y;
        }
        sum += (long) map[n].x * map[1].y;

        // 뺄셈 부분
        for (int i = 1 ; i < n ; i ++) {
            sum -= (long) map[i].y * map[i+1].x;
        }
        sum -= (long) map[n].y * map[1].x;

        double result = (double) Math.abs(sum) / 2;

        System.out.println(String.format("%.1f", result));

    }
}