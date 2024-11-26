import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(0, a);

        if (map.containsKey(b)) {
            System.out.println(map.get(b) + 1);
        } else {
            System.out.println(-1);
        }
    }

    static void dfs(int cnt, long from) {

        long val1 = from * 2;
        long val2 = from * 10 + 1;

        if (val1 <= 1_000_000_000 && !map.containsKey(val1)) {
            map.put((int)val1, cnt + 1);
            dfs(cnt+1, val1);
        }

        if (val2 <= 1_000_000_000 && !map.containsKey(val2)) {
            map.put((int)val2, cnt + 1);
            dfs(cnt+1, val2);
        }
    }
}