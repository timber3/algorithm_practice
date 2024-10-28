import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            // mid 이상의 과자를 m 개 이상 만들 수 있는지?
            if(canMake(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMake(int target) {
        int sum = 0;

        for (int i = n-1 ; i >= 0 ; i --) {

            if (sum >= m) break;

            if ((arr[i] / target) > 0) {
                sum += arr[i]/target;
            } else {
                break;
            }
        }

        if (sum >= m) {
            return true;
        }

        return false;
    }
}