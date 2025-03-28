import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int p, count;
    static LinkedList<Integer> list;

    public static void main(String[] args) throws Exception {
        p = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < p ; t ++) {
            list = new LinkedList<>();
            count = 0;

            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());

            sb.append(no).append(' ');

            for (int i = 0 ; i < 20 ; i ++) {
                int next = Integer.parseInt(st.nextToken());
                boolean put = false;
                if (list.isEmpty()) {
                    list.add(next);
                } else {
                    for (int v : list) {
                        if (v > next) {
                            list.add(list.indexOf(v), next);
                            count += list.size() - list.indexOf(v);
                            put = true;
                            break;
                        }
                    }
                    if (!put) {
                        list.addLast(next);
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
