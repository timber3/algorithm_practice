import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, d, k, c, max;
    static int[] arr, sushi;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sushi = new int[2 * n - 1];
        visited = new int[d + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sushi[i] = arr[i];
        }

        for (int i = n; i < sushi.length ; i++) {
            sushi[i] = arr[i - n];
        }

        int left = 0;
        int right = k-1;
        int count = 0;

        for (int i = 0 ; i < k ; i ++) {
            if (visited[sushi[i]] == 0) {
                count ++;
            }
            visited[sushi[i]] ++;
        }

        while(right < sushi.length) {

            // 확인 먼저 해주고
            if (count >= max) {
                if (visited[c] > 0) {
                    max = count;
                } else {
                    max = count + 1;
                }
            }

            // right, left 옮겨주고
            if (visited[sushi[left]] == 1) {
                count --;
            }
            visited[sushi[left]] --;
            left ++;

            right ++;
            if (right < sushi.length) {
                visited[sushi[right]] ++;
                if (visited[sushi[right]] == 1) {
                    count ++;
                }
            }
        }

        System.out.println(max);
    }
}