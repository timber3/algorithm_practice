import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] cards, list;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        cards = new int[n];
        list = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < m ; i ++) {
            if (Arrays.binarySearch(cards, Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}