import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int count;
    static int[] answer;
    static int[] select;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        answer = new int[10];
        select = new int[10];

        for (int i = 0 ; i < 10 ; i ++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(count);
    }

    static void dfs(int depth, int sum) {
        if (depth == 10) {
            if (sum >= 5) {
                count ++;
            }
            return;
        }


        for (int i = 1 ; i <= 5 ; i ++) {
            if (depth >= 2) {
                if (select[depth-1] == i && select[depth-2] == i) {
                    continue;
                }
            }

            select[depth] = i;
            if (answer[depth] == i) {
                dfs(depth + 1, sum + 1);
            } else {
                dfs(depth + 1, sum);
            }
        }
    }
}