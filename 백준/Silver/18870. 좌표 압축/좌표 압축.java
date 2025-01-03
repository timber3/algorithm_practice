import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }

        ArrayList<Integer> sortedArr = new ArrayList<>(set);

        for (int num : arr) {
            int index = Collections.binarySearch(sortedArr, num);
            sb.append(index).append(' ');
        }

        System.out.println(sb);
    }
}