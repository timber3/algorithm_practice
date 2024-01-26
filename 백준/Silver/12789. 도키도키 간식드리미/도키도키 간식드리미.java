import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, cur;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // 5 4 1 3 2
        // stack 맨 위에 값이 있는지 확인하기.
        for (int i = 0 ; i < n ; i ++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1 ; i <= n ; i ++) {
            // stack 맨 위에 검사하기
            if (!stack.isEmpty() && stack.peekLast() == i) {
                stack.pollLast();
                continue;
            }

            // q 에서 꺼내서 i가 나올때 까지 꺼내고 stack 에 넣기
            while(true) {
                // q 가 비어버리면 종료하기
                if (q.isEmpty()) {
                    System.out.println("Sad");
                    return;
                }
                // 꺼내서 확인하고 아니면 stack 에 넣기
                int t = q.poll();

                if (t == i) {
                    break;
                } else {
                    stack.add(t);
                }
            }
        }

        System.out.println("Nice");
    }
}