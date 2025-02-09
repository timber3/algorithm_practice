import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long count;
    static int[] A, B, C, D;
    static int[] AB, CD;

    public static void main(String[] args) throws Exception {
        // n : ~ 4000
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        AB = new int[n * n];
        CD = new int[n * n];

        int idx = 0;
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        for (int i = 0 ; i < AB.length ; i++) {
            int target = -AB[i];
            int left = lowerBound(target);
            int right = upperBound(target);

            count += (right - left);
        }

        System.out.println(count);
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = CD.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(int target) {
        int left = 0;
        int right = CD.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}