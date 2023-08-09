import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] ops = { '+' , '-', '*', '/'};

    static int T, n;
    static int[] operator; // + - X / 사용가능한 개수 저장용
    static int[] arr;
    static char[] form; // 연산자 조합 저장.
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;


    static int cal() {
        int cur = arr[0];

        for (int i = 0 ; i < n-1; i ++) {
            switch (form[i]){
                case '+' :
                    cur = cur + arr[i+1];
                    break;
                case '-' :
                    cur = cur - arr[i+1];
                    break;
                case '*' :
                    cur = cur * arr[i+1];
                    break;
                case '/' :
                    cur = cur / arr[i+1];
                    break;
            }
        }
        return cur;
    }

    static void permutation(int cnt) {
        // 하나의 조합을 완성했으면.
        if (cnt == n-1) {
            // 계산 해서 최대 최소 값 찾아주기.
            int result = cal();

            if (result > Max) Max = result;
            if (result < Min) Min = result;

            return;
        }

        for (int i = 0 ; i < 4 ; i ++) {
            if (operator[i] > 0) {
                operator[i] --;
                form[cnt] = ops[i];
                permutation(cnt + 1);
                operator[i] ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        
        for (int t= 0 ; t < T; t ++) {
            n = Integer.parseInt(br.readLine());

            operator = new int[4];
            
            form = new char[n-1];
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0 ; i < 4 ; i ++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0 ; i < n ; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 입력 끝
            
            permutation(0);

            System.out.printf("#%d %d\n",t+1 , Max - Min);

            
            Min = Integer.MAX_VALUE;
            Max = Integer.MIN_VALUE;
        }
    }
}
