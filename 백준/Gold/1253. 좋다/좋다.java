import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 목표 값 idx
        for (int i = 0 ; i < n ; i ++) {

            int target = arr[i];

            int left = 0;
            int right = n - 1;

            while(left < right) {

                if (left == i) {
                    left ++;
                    continue;
                }

                if (right == i) {
                    right --;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if (sum == target) {
                    result ++;
                    break;
                } else if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        System.out.println(result);
    }
}