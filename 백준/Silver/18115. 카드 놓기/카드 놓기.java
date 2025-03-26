import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 뒤에서 부터 처리
        for (int i = n - 1; i >= 0 ; i --) {
            int card = n - i;
            if (arr[i] == 1) {
                q.addFirst(card);
            } else if (arr[i] == 2) {
                int temp = q.pollFirst();
                q.addFirst(card);
                q.addFirst(temp);
            } else {
                q.addLast(card);
            }
        }

        for (int v : q) {
            sb.append(v).append(' ');
        }

        System.out.println(sb);

    }
}
