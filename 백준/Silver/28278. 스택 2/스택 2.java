import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            
            int order = Integer.parseInt(st.nextToken());
            
            if (order == 1) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (order == 2) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pollLast()).append('\n');
                }
            } else if (order == 3) {
                sb.append(stack.size()).append('\n');
            } else if (order == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (order == 5) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peekLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}