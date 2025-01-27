import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int len = 0;
        int oddCount = 0;

        while(left < n || right < n) {

            // 짝수면
            if (right < n && arr[right] % 2 == 0) {
                len ++;
                right ++;
            }
            // 홀수인데
            else {
                // 삭제할 수 있다면
                if (oddCount < k) {
                    oddCount ++;
                    right ++;
                }
                // 삭제할 수 없으면
                else {
                    // left 인덱스 값이 홀수인지 짝수인지 확인

                    // 짝수면
                    if (left < n && arr[left] % 2 == 0) {
                        len --;
                    }
                    // 홀수면
                    if (left < n && arr[left] % 2 == 1) {
                        oddCount--;
                    }

                    left ++;
                }
            }

            if (len > max) max = len;
        }

        System.out.println(max);
    }
}