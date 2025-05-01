import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, zero, count;
    static ArrayList<Belt> belt1;
    static ArrayDeque<Belt> belt2;

    static class Belt {
        boolean isRobot;
        int durability;

        public Belt(boolean isRobot, int durability) {
            this.isRobot = isRobot;
            this.durability = durability;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        belt1 = new ArrayList<>();
        belt2 = new ArrayDeque<>();

        for (int i = 0 ; i < n ; i ++) {
            belt1.add(new Belt(false, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0 ; i < n ; i ++) {
            belt2.addFirst(new Belt(false, Integer.parseInt(st.nextToken())));
        }

        solve();

        System.out.println(count);
    }

    static void solve() {
        while(true) {
            count ++;
            rotate();
            moveRobot();
            putRobot();
            if (zero >= k) break;

        }
    }

    static void rotate() {
        belt2.add(belt1.get(n-1));
        belt1.remove(n-1);
        belt1.add(0, belt2.poll());
        // 무조건 내린다. 없어도 그냥 false로
        belt1.get(n-1).isRobot = false;
    }

    static void moveRobot() {

        for (int i = n - 2 ; i >= 0 ; i --) {
            // 현재 칸에 로봇이 있다면
            Belt cur = belt1.get(i);
            if (cur.isRobot) {

                Belt next = belt1.get(i+1);
                if (!next.isRobot && next.durability > 0) {
                    cur.isRobot = false;
                    next.isRobot = true;
                    next.durability --;
                    if (next.durability == 0) zero ++;
                }
            }
        }
        // 무조건 내린다. 없어도 그냥 false로
        belt1.get(n-1).isRobot = false;

    }

    static void putRobot () {
        Belt first = belt1.get(0);
        if (first.durability > 0) {
            first.isRobot = true;
            first.durability --;
            if (first.durability == 0) zero ++;

        }
    }
}