import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static int n, m, result;
    static int[] books;
    static ArrayList<Integer> minus = new ArrayList<>();
    static ArrayList<Integer> plus = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        books = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(books);

        for (int i = 0 ; i < n ; i ++) {
            if (books[i] < 0) {
                minus.add(Math.abs(books[i]));
            } else if (books[i] > 0) {
                plus.add(books[i]);
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());


        int max = 0;

        if (!plus.isEmpty()) {
            int val = plus.get(0);
            if (val > max) max = val;
        }
        if (!minus.isEmpty()) {
            int val = minus.get(0);
            if (val > max) max = val;
        }

        for (int i = 0 ; i < plus.size() ; i += m) {
            result += plus.get(i) * 2;
        }

        for (int i = 0 ; i < minus.size() ; i += m) {
            result += minus.get(i) * 2;
        }

        result -= max;

        System.out.println(result);

    }
}