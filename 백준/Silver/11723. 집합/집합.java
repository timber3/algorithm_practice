import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int m;
    static boolean[] arr;

    public static void main(String[] args) throws Exception {
        m = Integer.parseInt(br.readLine());

        arr = new boolean[21];

        for (int i = 0 ; i < m ; i ++) {

            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            int val = 0;
            if (!(order.equals("all") || order.equals("empty"))) {
                val = Integer.parseInt(st.nextToken());
            }

            if (order.equals("add")) {
                arr[val] = true;
            } else if (order.equals("remove")) {
                arr[val] = false;
            } else if (order.equals("check")) {
                if (arr[val])
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            } else if (order.equals("toggle")) {
                arr[val] = !arr[val];
            } else if (order.equals("all")) {
                for (int j = 1 ; j <= 20 ; j ++) {
                    arr[j] = true;
                }
//                Arrays.fill(arr, true);
            } else if (order.equals("empty")) {
                for (int j = 1 ; j <= 20 ; j ++) {
                    arr[j] = false;
                }
//                Arrays.fill(arr, false);
            }
        }
        System.out.println(sb);
    }
}
