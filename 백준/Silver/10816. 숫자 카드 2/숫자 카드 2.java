import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp+1);
            } else {
                map.put(arr[i], 1);
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);

        for (int i = 0 ; i < m ; i ++) {
            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = arr.length - 1;

            while(left <= right) {
                int mid = (left + right) / 2;

                if (target == arr[mid]) {
                    sb.append(map.get(arr[mid])).append(" ");
                    break;
                }

                if (target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (left > right) sb.append(0).append(" ");

        }

        System.out.println(sb);
    }
}