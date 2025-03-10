import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        count = (str.length() + 1) * 26 - str.length();

        System.out.println(count);
    }
}