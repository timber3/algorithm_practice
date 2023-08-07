import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;

    static class Tower{
        int idx;
        int height;
        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;

        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // 타워를 저장함.
        Stack<Tower> s = new Stack<Tower>();

        for (int i = 1; i <= n; i++) {

            int cur_height = Integer.parseInt(st.nextToken());

            if (s.isEmpty()){
                sb.append("0 ");
                s.push(new Tower(i, cur_height));
            } else {

                while (true) {
                    if (s.isEmpty()){
                        sb.append("0 ");
                        s.push(new Tower(i, cur_height));
                        break;
                    }

                    if (s.peek().height > cur_height) {
                        sb.append(s.peek().idx + " ");
                        s.push(new Tower(i, cur_height));
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
        }
        
        System.out.println(sb.toString());
        
    }
}
