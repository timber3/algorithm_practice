import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if ( n - m < m ) m = n - m;

        BigInteger son = BigInteger.ONE;
        BigInteger mom = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            son = son.multiply(BigInteger.valueOf(i));
        }
        
        for (int i = 1; i <= m; i++) {
            mom = mom.multiply(BigInteger.valueOf(i));
        }
        
        for (int i = 1; i <= (n - m); i++) {
            mom = mom.multiply(BigInteger.valueOf(i));
        }
        
        BigInteger result = son.divide(mom);
        System.out.println(result);
    }
}
