import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static double n, m;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Double.parseDouble(st.nextToken());
        m = Double.parseDouble(st.nextToken());

        System.out.println(n/m);
    }
}