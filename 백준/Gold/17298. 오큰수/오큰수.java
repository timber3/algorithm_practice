import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[] result;
    static ArrayDeque<Node> q = new ArrayDeque<>();

    static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i ++) {
            result[i] = -1;
        }
        // input

        for (int i = 0 ; i < n ; i ++) {
            // 비어있거나 아니면 꼭대기 값이 더 크면 q에 넣는다.
            if (q.isEmpty() || q.peekLast().val >= arr[i]) {
                q.add(new Node(arr[i], i));
            }
            // 비어있지 않고 꼭대기 값보다 크다면
            else {
                int count = 0;
                // q가 빌 때 까지 확인하기
                while(!q.isEmpty()) {
                    if (q.peekLast().val < arr[i]) {
                        Node node = q.pollLast();
                        result[node.idx] = arr[i];
                    } else {
                        break;
                    }
                }
                q.add(new Node(arr[i], i));
            }
        }

        result[n-1] = -1;

        for (int i = 0 ; i < n ; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);

    }
}