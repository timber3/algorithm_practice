import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static boolean flag;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        dfs(0);

        for (int i = 0 ; i < n ; i ++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == n) {
            flag = true;
            return;
        }

        for (int i = 1 ; i <= 3 ; i ++) {
            arr[depth] = i;
            if (isDuplicated(depth + 1)) {
                continue;
            }
            dfs(depth + 1);
            if (flag) return;
        }

    }
    
    static boolean isDuplicated(int len) {
        // 부분수열의 길이
        for (int i = 1 ; i <= len / 2 ; i++) {
            boolean dup = true;

            // 시작 인덱스는 j
            for (int j = 0 ; j <= len - (i * 2) ; j ++) {
                dup = true;
                int left = j;
                int right = j + i;

                // 확인 하는 로직
                for (int k = 0 ; k < i ; k ++) {
                    if (arr[left + k] != arr[right + k]) {
                        dup = false;
                        break;
                    }
                }

                if (dup)
                    return true;
            }
        }

        return false;
    }
}