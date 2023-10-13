import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] S = br.readLine().split(" ");
        Arrays.sort(S, (a, b) -> (b + a).compareTo(a + b));

        String s = String.join("", S);
        System.out.println(s.charAt(0) == '0' ? 0 : s);
    }
}