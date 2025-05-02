import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int h, w, count;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[w];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < w ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(count);
    }

    static void solve() {

        // 왼쪽 끝, 오른쪽 끝으로 가면서 현재 칸보다 높은 칸 중에서 가장 높은 벽을 찾고, 없으면 그 칸에는
        for (int cur = 1 ; cur <= w-2 ; cur ++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int next = cur - 1 ; next >= 0 ; next--) {
                if (arr[next] > arr[cur] && leftMax < arr[next]) {
                    leftMax = arr[next];
                }
            }

            for (int next = cur + 1 ; next <= w - 1; next++) {
                if (arr[next] > arr[cur] && rightMax < arr[next]) {
                    rightMax = arr[next];
                }
            }

            if (leftMax != 0 && rightMax != 0) {
                if (leftMax > rightMax) {
                    count += (rightMax - arr[cur]);
                } else {
                    count += (leftMax - arr[cur]);
                }
            }
        }
    }
}