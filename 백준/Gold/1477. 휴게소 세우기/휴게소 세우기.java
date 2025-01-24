import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, l, result;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n+2];

        // 고속도로 시작과 끝
        arr[0] = 0;
        arr[n+1] = l;

        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1 ; i < n+1 ; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
        // input

        // 특정 조건을 만족하는 값의 최대 혹은 최소 를 구한다 -> 이분탐색   ('휴게소가 없는 구간의 최대값' 을 최소로)
        int left = 1;
        int right = l-1;

        while(left < right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1 ; i < n+2 ; i ++) {
                int dis = (arr[i] - arr[i - 1] - 1) / mid;
                // 설치한 휴게소 수
                count += dis;
            }

            // 휴게소 간 거리를 줄여서 다시 해보기
            if (count == m) {
                right = mid;
                result = mid;
            }
            // count가 많다 => 측정하는 거리가 너무 작다 => 거리를 늘리기
            else if (count > m){
                left = mid + 1;
            } else {
                right = mid;
                result = mid;
            }
        }
        System.out.println(result);
    }
}