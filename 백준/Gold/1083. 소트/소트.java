import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, s;
    static int[] arr;
    static Integer[] sorted;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        s = Integer.parseInt(br.readLine());

        Arrays.sort(sorted, (o1, o2) -> {
            return o2 - o1;
        });

        int idx = 0;

        while (s > 0 && idx < n) {
            s = sort(idx, s);
            idx++;
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    static int sort(int idx, int s) {
        int MAX = 0;
        int MAX_idx = idx;

        // s 거리 사이에 최대값 구하기
        for (int i = idx; i < Math.min(idx + s + 1, n); i++) {
            if (arr[i] > MAX) {
                MAX = arr[i];
                MAX_idx = i;
            }
        }

        // 최대값을 앞으로 이동
        for (int i = MAX_idx; i > idx; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            s--;
        }

        return s;
    }
}