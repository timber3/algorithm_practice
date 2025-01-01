import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result = Integer.MAX_VALUE;
    static int[] arr;

    static HashSet<Integer> sum = new HashSet<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        for (int i = n-1 ; i >= 0  ; i --) {
            for (int j = 0 ; j < n ; j ++) {
                if (sum.contains(arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

    }
}