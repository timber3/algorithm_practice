import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, n, m;
    static long count;
    static int[] arr1, arr2;
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr1[j];
                list1.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += arr2[j];
                list2.add(sum);
            }
        }

        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            int target = t - list1.get(i);
            count += upperBound(list2, target) - lowerBound(list2, target);
        }

        System.out.println(count);
    }

    static int upperBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size(); // right는 list.size()로 초기화

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) { // target보다 작거나 같으면 left를 mid + 1로
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size(); // right는 list.size()로 초기화

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) { // target보다 작으면 left를 mid + 1로
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}