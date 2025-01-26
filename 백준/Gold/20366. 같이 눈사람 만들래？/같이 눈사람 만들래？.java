import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, min = Integer.MAX_VALUE;
    static int[] arr;
    static ArrayList<snowMan> list = new ArrayList<>();

    static class snowMan {
        int i;
        int j;
        int len;

        public snowMan(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0 ; i < n ; i ++) {
            for (int j = i+1 ; j < n ; j ++) {
                list.add(new snowMan(i, j, arr[i] + arr[j]));
            }
        }

        // len 으로 정렬
        Collections.sort(list, (o1, o2) -> {
            return o1.len - o2.len;
        });

        for (int i = 0 ; i < list.size() ; i++) {
            snowMan anna = list.get(i);

            for (int j = i + 1 ; j < list.size() ; j ++) {
                snowMan elsa = list.get(j);

                // 눈사람 인덱스가 하나라도 겹치는게 있으면 안됨
                if (anna.i == elsa.i || anna.i == elsa.j || anna.j == elsa.i || anna.j == elsa.j) {
                    continue;
                } else {
                    int diff = elsa.len - anna.len;

                    if (diff >= min) {
                        break;
                    }
                    else {
                        min = diff;
                    }
                }
            }
        }
        System.out.println(min);
    }
}