import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, result = Integer.MAX_VALUE;
    static int[] origin, cur, target;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        origin = new int[n];
        target = new int[n];
        cur = new int[n];

        String str = br.readLine();

        for (int i = 0 ; i < n ; i ++) {
            origin[i] = str.charAt(i) - '0';
            cur[i] = origin[i];
        }

        str = br.readLine();

        for (int i = 0 ; i < n ; i ++) {
            target[i] = str.charAt(i) - '0';
        }

        int count = 1;

        // 맨 앞을 눌렀을 때
        cur[0] = (cur[0] + 1) % 2;
        cur[1] = (cur[1] + 1) % 2;

        for (int i = 1 ; i < n ; i ++) {
            // 이전 전구가 다르면 그냥 현재꺼를 누른다.
            if (cur[i-1] != target[i-1]) {
                cur[i-1] = (cur[i-1]  + 1) % 2;
                cur[i] = (cur[i] + 1) % 2;
                if (i + 1 < n ) cur[i+1] = (cur[i+1] + 1) % 2;
                count ++;
            }
        }

        if (cur[n-1] == target[n-1]) {
            result = Math.min(result, count);
        }

        count = 0;

        // 맨 앞을 안 눌렀을 때
        for (int i = 0 ; i < n ; i ++) {
            cur[i] = origin[i];
        }

        for (int i = 1 ; i < n ; i ++) {
            // 이전 전구가 다르면 그냥 현재꺼를 누른다.
            if (cur[i-1] != target[i-1]) {
                cur[i-1] = (cur[i-1]  + 1) % 2;
                cur[i] = (cur[i] + 1) % 2;
                if (i + 1 < n ) cur[i+1] = (cur[i+1] + 1) % 2;
                count ++;
            }
        }

        if (cur[n-1] == target[n-1]) {
            result = Math.min(result, count);
        }

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}