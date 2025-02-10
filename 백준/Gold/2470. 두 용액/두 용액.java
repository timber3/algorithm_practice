import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, resultLeft, resultRight;
    static int minDif = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;

        while(left < right) {

            int sum = arr[left] + arr[right];
            int sumAbs = Math.abs(sum);

            if (sumAbs == 0) {
                resultLeft = left;
                resultRight = right;
                break;
            } else if (sumAbs < minDif) {
                minDif = sumAbs;
                resultLeft = left;
                resultRight = right;
            } else {
                if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }

        System.out.println(arr[resultLeft] + " " + arr[resultRight]);

    }
}