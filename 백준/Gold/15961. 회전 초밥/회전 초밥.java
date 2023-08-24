import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int[] selected;
    static int start, end;
    static int Max;
    static int n, d, k, c;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[3_003_003];
        selected = new int[3003];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // n 배열 뒤에 k개만큼 n 배열 앞 부분 떼서 넣어주기
        for (int i = n; i < n + k; i++) {
            arr[i] = arr[i-n];
        }

        int sum = 0;

        // 처음 k개 계산 해보기
        for (int i = 0 ; i < k ; i ++) {
            if (selected[arr[i]] == 0) {   // 만약 선택 된 적 없는 원소라면
                sum++;  // 합에 더해주기
            }
            selected[arr[i]] += 1;
        }

        Max = sum;
        // 최댓값 갱신
        if (selected[c] == 0) {
            Max++;
        }

        start = 0;
        end = k - 1;

        while(start != n) {
            // 만약 빼려는 애가 딱 한 개 있었다면 sum의 값에서 빼줘야 함.
            if (selected[arr[start]] == 1)
                sum--;

            // start 인덱스의 selected - 1
            selected[arr[start]] --;

            start++;
            end++;

            // end 인덱스의 원소가 선택된 적 없다면
            if (selected[arr[end]] == 0){
                sum ++; // sum 더해주기
            }
            
            selected[arr[end]] ++;  // end 인덱스의 값 선택해주기

            if (sum >= Max) {
                Max = sum;
                if (selected[c] == 0) {
                    Max ++;
                }
            }
        }

        System.out.println(Max);
    }
}
