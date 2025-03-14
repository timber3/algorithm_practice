import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, cursor;
    static String str;
    static LinkedList<Character> result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t= 0 ; t < T ; t ++) {
            str = br.readLine();
            result = new LinkedList<>();
            cursor = 0;

            for (int i = 0 ; i < str.length() ; i ++) {
                char order = str.charAt(i);

                if (order == '-') {
                    if (cursor != 0) {
                        result.remove(cursor-1);
                        cursor --;
                    }
                } else if (order == '<') {
                    // 커서는 0보다 커야한다.
                    if (cursor != 0)
                        cursor --;
                } else if (order == '>') {
                    // 커서는 최대 문자열 길이까지 가능
                    if (cursor != result.size())
                        cursor ++;
                } else {
                    result.add(cursor, order);
                    cursor++;
                }
            }

            for (char c : result) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}