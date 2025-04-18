//15:48

import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static String w;
    static int T, k, min, max;
    static ArrayList<Integer>[] list;


    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {

            w = br.readLine();
            k = Integer.parseInt(br.readLine());

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            list = new ArrayList[26];
            for (int i = 0 ; i < 26; i ++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < w.length() ; i ++) {
                char c = w.charAt(i);
                int idx = c - 'a';

                // 언제 등장했는지 저장하기
                list[idx].add(i);
            }

            for (int i = 0 ; i < list.length ; i ++) {
                if (list[i].size() >= k) {

                    for (int j = 0 ; j + (k-1) < list[i].size() ; j ++) {
                        if (min > list[i].get(j + (k-1)) - list[i].get(j) + 1) min = list[i].get(j + (k-1)) - list[i].get(j) + 1;
                        if (list[i].get(j + (k-1)) - list[i].get(j) + 1 > max) max = list[i].get(j + (k-1)) - list[i].get(j) + 1;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.printf("%d %d\n", min, max);
            }

        }

    }
}