import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static HashMap<String, Node> map = new HashMap<String, Node>();
    static StringBuilder sb;

    static class Node {
        String left;
        String right;

        Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            String par = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            map.put(par, new Node(left, right));
        }
        sb = new StringBuilder();
        forward("A");
        System.out.println(sb);
        sb = new StringBuilder();
        middle("A");
        System.out.println(sb);
        sb = new StringBuilder();
        backward("A");
        System.out.println(sb);
    }
    // 중간 -> 왼쪽 -> 오른쪽
    static void forward(String root) {
        sb.append(root);

        Node next = map.get(root);

        if (!".".equals(next.left)) {
            forward(next.left);
        }
        if (!".".equals(next.right)) {
            forward(next.right);
        }
    }

    // 왼쪽 -> 중간 -> 오른쪽
    static void middle(String root) {
        Node next = map.get(root);
        if (!".".equals(next.left)) {
            middle(next.left);
        }
        sb.append(root);
        if (!".".equals(next.right)) {
            middle(next.right);
        }
    }

    // 왼쪽 -> 오른쪽 -> 중간
    static void backward(String root) {

        Node next = map.get(root);

        if (!".".equals(next.left)) {
            backward(next.left);
        }
        if (!".".equals(next.right)) {
            backward(next.right);
        }
        sb.append(root);
    }

}