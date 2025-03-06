import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, count;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new boolean[1000];

        for (int i = 123 ; i <= 987 ; i ++) {
            arr[i] = true;
        }

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            cal(q, strike, ball);
        }

        for (int i = 123 ; i <= 987 ; i ++) {
            if(arr[i]) count ++;
        }

        System.out.println(count);

    }

    static void cal(int q, int strike, int ball) {
        // q가 strike, ball에 조건에 맞는 값을 찾으면 arr 체크 하기.
        int first = q / 100;
        q %= 100;
        int second = q / 10;
        q %= 10;
        int third = q;

        // 각 자리수는 전부 다르다.
        for (int i = 123 ; i <= 987 ; i ++) {

            int next = i;
            int tempStrike = 0;
            int tempBall = 0;

            int nFirst = next / 100;
            next %= 100;
            int nSecond = next / 10;
            next %= 10;
            int nThird = next;

            // 각 자리수가 전부 다른 숫자인지 확인 필요
            if (nFirst == nSecond || nSecond == nThird || nFirst == nThird)  {
                arr[i] = false;
                continue;
            }

            // 0이 오면안됨.
            if (nFirst == 0 || nSecond  == 0 || nThird == 0) {
                arr[i] = false;
                continue;
            }



            if (nFirst == first) tempStrike ++;
            if (nSecond == second) tempStrike ++;
            if (nThird == third) tempStrike ++;

            if (first == nSecond || first == nThird) tempBall++;
            if (second == nFirst || second == nThird) tempBall++;
            if (third == nSecond || third == nFirst) tempBall++;

            if (strike != tempStrike || ball != tempBall) arr[i] = false;

        }
    }
}
