import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int result = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = n - 1;

        while(left <= right && left != right) {
            if (arr[right] + arr[left] == 0) {
                resultLeft = left;
                resultRight = right;
                break;
            } else if (arr[left] + arr[right] > 0) {
                if (Math.abs(arr[right] + arr[left]) < result) {
                    resultLeft = left;
                    resultRight = right;
                    result = Math.abs(arr[right] + arr[left]);
                }
                right = right - 1;
            } else {
                if (Math.abs(arr[right] + arr[left]) < result) {
                    resultLeft = left;
                    resultRight = right;
                    result = Math.abs(arr[right] + arr[left]);
                }
                left = left + 1;
            }
        }

        System.out.println(arr[resultLeft] + " " + arr[resultRight]);
    }
}