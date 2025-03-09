import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m, count;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();
            set.add(str);
        }

        for (int i = 0 ; i < m ; i ++) {
            String str = br.readLine();
            if (set.contains(str)) count ++;
        }

        System.out.println(count);

    }
}