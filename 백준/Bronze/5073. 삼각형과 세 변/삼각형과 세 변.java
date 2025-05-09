import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int[] sides = {a, b, c};
            Arrays.sort(sides);
            a = sides[0];
            b = sides[1];
            c = sides[2];

            if (a + b <= c) {
                sb.append("Invalid\n");
            } else if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a == b || b == c || a == c) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }

        System.out.print(sb);
    }
}