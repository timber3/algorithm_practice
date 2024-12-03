import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int su, bro;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws Exception {


        st = new StringTokenizer(br.readLine());

        su = Integer.parseInt(st.nextToken());

        bro = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, -1);

        arr[su] = 0;

        bfs();

        System.out.println(arr[bro]);

    }

    static void bfs() {

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(su);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (2*cur <= 100000 && (arr[cur*2] == -1 || arr[cur] < arr[cur*2])) {
                q.add(2*cur);
                arr[2*cur] = arr[cur];
            }
            if (cur + 1 <= 100000 && (arr[cur+1] == -1 || arr[cur] + 1 < arr[cur+1])) {
                q.add(cur+1);
                arr[cur+1] = arr[cur] + 1;
            }
            if (cur - 1 >= 0 && (arr[cur-1] == -1 || arr[cur] + 1 < arr[cur-1])) {
                q.add(cur-1);
                arr[cur-1] = arr[cur] + 1;
            }
        }
    }
}