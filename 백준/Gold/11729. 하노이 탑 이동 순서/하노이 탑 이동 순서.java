import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        hanoi(1, 2 ,3, n);

        System.out.println(count+1);
        System.out.print(sb);
    }
    // 어디에서 어디를 거쳐서 어디로 위에서 부터 몇개 보낼건지
    static void hanoi(int from, int mid, int to, int plate) {

        if (plate == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        hanoi(from, to, mid, plate - 1);
        count ++;

        sb.append(from).append(' ').append(to).append('\n');

        hanoi(mid, from, to, plate - 1);
        count ++;
    }
}
