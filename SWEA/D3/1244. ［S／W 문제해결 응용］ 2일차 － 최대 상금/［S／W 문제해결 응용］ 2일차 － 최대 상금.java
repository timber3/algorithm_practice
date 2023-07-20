import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static Integer[] best_case;
    static int change;
    static int max_value;
    static int n;
    static boolean max_found = false;

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void dfs(int cnt) {

        if (max_found)
            return;

        if (cnt-1 == change) {

            int sum = 0;
            int m = 1;

            for (int i = n-1; i >= 0; i--) {
                sum += arr[i] * m;
                m *= 10;
            }

            max_value = Math.max(max_value, sum);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                // 교환 하기
                swap(i, j);

                boolean is_max = true;

                // 교환하고 나서 최대값인지 확인하기
                for (int k = 0; k < n; k++) {
                    if (arr[k] != best_case[k]) {
                        is_max = false;
                        break;
                    }
                }

                // 최대값과 같은 배열이 만들어 졌다면
                if (is_max) {
                    max_found = true;

                    // 남은 교환 횟수로 마지막 자리 정하기

                    // 현재 1번 돌았으니 남은 횟수가 홀수면
                    if ((change - cnt) % 2 == 1){
                        // 중복 체크
                        boolean dup = false;
                        int[] dup_check = new int[10];

                        for (int k = 0; k < n; k++) {
                            dup_check[k] = 0;
                        }

                        for (int k = 0; k < n; k++) {
                            if (dup_check[arr[k]] == 0)
                                dup_check[arr[k]] = 1;
                            else{
                                dup = true;
                                break;
                            }
                        }

                        if (!dup) {
                            swap(n-1,n-2);
                        }
                    }

                    int sum = 0;
                    int m = 1;
                    for (int k = n-1 ; k >= 0; k--) {
                        sum += arr[k] * m;
                        m *= 10;
                    }

                    max_value = sum;
                    return;
                }

                dfs(cnt + 1);

                if (max_found) {
                    return;
                }

                // 다시 서로 바꿔주기
                swap(i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            n = input.length();
            change = Integer.parseInt(st.nextToken());
            arr = new int[n];
            best_case = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input.charAt(i) - '0';
            }

            for (int i = 0; i < n; i++) {
                best_case[i] = arr[i];
            }

            Arrays.sort(best_case, Comparator.reverseOrder());

            dfs(1);

            System.out.println("#" + (t+1) + " " + max_value);
            max_value = 0;
            max_found = false;
        }
    }
}

