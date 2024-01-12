import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long sum;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            int a = Integer.parseInt(br.readLine());
            if (!q.isEmpty()) {
                if (q.peekLast() > a) {
                    q.add(a);
                    sum += q.size() - 1;
                } else {
                    while(!q.isEmpty() && q.peekLast() <= a) {
                        q.pollLast();
                    }
                    q.add(a);
                    sum += q.size() - 1;
                }
            } else {
                q.add(a);
            }
        }
        System.out.println(sum);
    }
}