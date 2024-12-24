import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;
    static boolean[] prime;
    static Integer[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        prime = new boolean[n+1];
        list = new ArrayList<>();

        Arrays.fill(prime, true);

        prime[1] = false;

        for (int i = 2 ; i <= n ; i ++) {
            if (prime[i]) {
                int j = 2;
                while(i * j <= n) {
                    prime[i*j] = false;
                    j++;
                }
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            if (prime[i])
                list.add(i);
        }

        arr = list.toArray(new Integer[0]);

        int left = 0;
        int right = 0;
        int sum = 0;

        while(true) {
            // 목표 값 보다 작으면 right를 한 칸 밀기
            // 목표 값 보다 크면 left를 한 칸 밀기
            // 목표 값이면 count + 1;

            if (sum == n) {
                count ++;
                sum -= arr[left++];
            } else if (sum < n) {
                if (right >= arr.length) break;
                sum += arr[right++];
            } else if (sum > n) {
                sum -= arr[left++];
            }
        }

        System.out.println(count);
    }
}