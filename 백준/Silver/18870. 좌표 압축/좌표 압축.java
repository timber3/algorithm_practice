import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static ArrayList<Integer> sortedArr = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                sortedArr.add(arr[i]);
            }
        }

        Collections.sort(sortedArr);

        for (int i = 0 ; i < n ; i ++) {

            int left = 0;
            int right = sortedArr.size() - 1;

            int target = arr[i];

            while(left < right) {
                int mid = (left + right) / 2;

                if (sortedArr.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(left).append(' ');

        }

        System.out.println(sb);
    }

}