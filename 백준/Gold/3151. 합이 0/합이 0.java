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

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //left
        for (int i = 0 ; i < n - 2 ; i ++) {
            //right
            for (int j = i + 1; j < n - 1 ; j ++) {

                // a + b + c = 0   =>  a + b = -c
                int target = -(arr[i] + arr[j]);
                int start = j + 1;
                int end = n;

                int lowerBound = lowerBound(target, start, end);
                int upperBound = upperBound(target, start, end);

                result += (upperBound - lowerBound);
            }
        }

        System.out.println(result);

    }

    static int lowerBound(int target, int start, int end) {

        while(start < end) {

            int mid = (start + end) / 2;

            // arr[mid] 가 target 과 같거나 큰 값이 나오면
            if (arr[mid] >= target ) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int upperBound(int target, int start, int end) {

        while(start < end) {

            int mid = (start + end) / 2;

            // arr[mid] 가 target 보다 큰 값이 나오면
            if (arr[mid] > target ) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

}