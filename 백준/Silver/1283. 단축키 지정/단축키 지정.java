import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++) {

            String[] strs = br.readLine().split(" ");
            boolean flag = false;

            // 배열 크기만큼 순회하면서 첫글자가 map에 없다면 추가해주기
            for (int j = 0 ; j < strs.length; j ++) {
                // set에 넣은적이 없었다면
                if (!flag && set.add(String.valueOf(strs[j].charAt(0)).toUpperCase())) {
                    sb.append('[').append(strs[j].charAt(0)).append(']').append(strs[j].substring(1)).append(' ');
                    flag = true;
                } else {
                    sb.append(strs[j]).append(' ');
                }
            }

            // 만약 앞 글자 중에서 찾아서 대괄호를 붙였다면
            if (flag) {
                sb.append('\n');
            }

            // 각 단어들의 앞글자들이 이미 들어있다면 다시 배열을 돌면서 한단어마다 글자를 전부 순회하면서 확인하기
            if (!flag) {

                String result = "";
                for (int j = 0 ; j < strs.length ; j ++) {
                    result = result.concat(strs[j] + " ");
                }

                sb.delete(sb.length() - result.length(), sb.length());

                boolean flag2 = false;
                for (int j = 0 ; j < strs.length; j ++) {

                    if (flag2) {
                        sb.append(strs[j]).append(' ');
                        continue;
                    }
                    for (int k = 0 ; k < strs[j].length(); k ++) {

                        if (set.add(String.valueOf(strs[j].charAt(k)).toUpperCase())) {
                            sb.append(strs[j].substring(0, k));
                            sb.append('[').append(strs[j].charAt(k)).append(']').append(strs[j].substring(k+1)).append(' ');
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        sb.append(strs[j]).append(' ');
                    }
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);



    }
}