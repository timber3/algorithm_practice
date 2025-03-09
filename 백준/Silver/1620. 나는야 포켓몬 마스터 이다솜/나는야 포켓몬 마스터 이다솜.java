import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static HashMap<Integer, String> intMap = new HashMap<>();
    static HashMap<String, Integer> stringMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        // 포켓몬
        n = Integer.parseInt(st.nextToken());
        // 문제
        m = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= n ; i ++ ) {
            String str = br.readLine();

            intMap.put(i,str);
            stringMap.put(str,i);

        }

        for (int i = 0 ; i < m ; i ++ ){
            String str = br.readLine();
            char first = str.charAt(0);
            if ((first >= 'a' && first <= 'z') || (first >= 'A' && first <= 'Z')) {
                System.out.println(stringMap.get(str));
            } else {
                System.out.println(intMap.get(Integer.parseInt(str)));
            }
        }

    }
}