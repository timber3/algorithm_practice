import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String input;
    static int q, u, a, c, k;
    static int max;

    public static void main(String[] args) throws Exception {

        input = br.readLine();

        for (int i = 0 ; i < input.length(); i ++) {
            if (input.charAt(i) == 'q') {
                q++;
            } else if (input.charAt(i) == 'u') {
                u++;
                if (q < u) {
                    System.out.println(-1);
                    return;
                }
            } else if (input.charAt(i) == 'a') {
                a++;
                if (q < a || u < a) {
                    System.out.println(-1);
                    return;
                }
            } else if (input.charAt(i) == 'c') {
                c++;
                if (q < c || u < c || a < c) {
                    System.out.println(-1);
                    return;
                }
            } else if (input.charAt(i) == 'k') {
                k++;
                if (q < k || u < k || a < k || c < k) {
                    System.out.println(-1);
                    return;
                }
            }

            if (q > 0 && u > 0 && a > 0 && c > 0 && k > 0) {
                max = Math.max(Math.max(Math.max(Math.max(Math.max(q, u),a),c),k), max);
                q--;
                u--;
                a--;
                c--;
                k--;
            }
        }
        
        if (q != 0 || u != 0 || a != 0 || c != 0 || k != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(max);
    }
}