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

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (!nextPermutation()) {
            System.out.println(-1);
            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }

    static boolean nextPermutation() {

        int i = arr.length - 2;

        while(i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false;

        int j = arr.length - 1;

        while(arr[i] >= arr[j]) {
            j--;
        }

        swap(i, j);

        reverse(i+1, arr.length - 1);

        return true;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(int start, int end) {
        while(start < end) {
            swap(start++, end--);
        }
    }
}