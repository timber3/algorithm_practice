import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[] arr;
    static int[] result;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 0 으로 부터의 거리

        int rLeft = 0;
        int rThird = 0;
        int rRight = 0;

        long min = Long.MAX_VALUE;

        for (int i = 0 ; i < n ; i ++) {

            int left = 0;
            int right = n-1;
            // 첫번째 두번째 용액은 투포인터로 인덱싱
            // 세번째 용액을 하나의 인덱스로 관리하기 ( for 문 돌리면서 확인 )
            int third = i;

            while( left < right ) {
                // 세 용액은 다른 용액이어야 함.
                if (left == third) {
                    left ++;
                    continue;
                }
                if (right == third) {
                    right --;
                    continue;
                }

                long midValue = arr[left] + arr[right] + arr[third];

                // min이 최소가 될 수 있는 지점 저장.
                if (min > Math.abs(midValue)) {
                    min = Math.abs(midValue);
                    rLeft = left;
                    rRight = right;
                    rThird = third;
                }

                if ( midValue == 0 ){
                    rLeft = left;
                    rRight = right;
                    rThird = third;
                    break;
                } else if ( 0 < midValue ) {
                    right --;
                } else {
                    left ++;
                }


            }
        }

        result = new int[] {rLeft, rRight, rThird};

        Arrays.sort(result);

        System.out.println(arr[result[0]] + " " + arr[result[1]] + " " + arr[result[2]]);

    }
}