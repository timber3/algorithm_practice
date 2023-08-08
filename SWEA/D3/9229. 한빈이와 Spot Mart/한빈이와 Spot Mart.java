import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, T;
    static int Max = -1;
    static int[] arr;

    static void permutation(int cnt, int sum, int idx) {

        if (cnt == 2) {
            if(sum <= m) {
                Max = Math.max(sum, Max);
            }
            return;
        }

        for (int i = idx ; i < n ; i ++)
        {
            permutation(cnt+1, sum + arr[i], i+1);
        }

    }

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0, 0, 0);

            System.out.printf("#%d %d\n", t+1, Max);

            Max = -1;

        }

    }

}
