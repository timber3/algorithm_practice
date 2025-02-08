import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static char[] arr;

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            String str = br.readLine();

            arr = new char[str.length()];

            for (int i = 0 ; i < str.length(); i ++) {
                arr[i] = str.charAt(i);
            }

            nextPermutation();

            for (int i = 0 ; i < arr.length ; i++) {
                sb.append(arr[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void nextPermutation() {

        int i = arr.length - 2;

        while(i >= 0 && arr[i] >= arr[i+1]) {
            i--;
        }

        if (i < 0) return;

        int j = arr.length - 1;

        while(arr[i] >= arr[j]) {
            j--;
        }

        swap(i, j);

        reverse(i + 1, arr.length - 1);
    }

    static void swap(int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(int start, int end) {
        while(start < end) {
            swap(start++, end--);
        }
    }
}