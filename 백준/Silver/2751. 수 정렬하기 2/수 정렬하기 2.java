import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n ; i ++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        
        while(!q.isEmpty()) {
            sb.append(q.poll()).append('\n');
        }

        System.out.println(sb);
    }
}