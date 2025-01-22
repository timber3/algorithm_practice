import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, c, result;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 1 ; i < n ; i ++) {
            list.add(arr[i] - arr[i-1]);
        }

        int left = 0;
        int right = arr[n-1] - arr[0] + 1;

        while(left < right) {
            int mid = (left + right) / 2;

            // mid 크기 만큼 거리를 두면서 공유기를 둘 수 있는지 확인
            if (check(mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(result);

    }

    static boolean check(int dis) {
        int count = 1;  // 공유기를 둔 횟수
        int sum = 0;  // 거리의 합

        for (int i = 0 ; i < list.size() ; i ++) {
            if (sum < dis) {
                sum += list.get(i);
            }

            if (sum >= dis) {
                sum = 0;
                count ++;
            }
        }

        if (count >= c) {
            return true;
        }

        return false;
    }
}