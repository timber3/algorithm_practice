import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int jX, jY, jD, bX, bY, bD;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            jX = Integer.parseInt(st.nextToken());
            jY = Integer.parseInt(st.nextToken());
            jD = Integer.parseInt(st.nextToken());
            bX = Integer.parseInt(st.nextToken());
            bY = Integer.parseInt(st.nextToken());
            bD = Integer.parseInt(st.nextToken());

            // 두 점 사이의 거리 계산
            double jbDist = Math.sqrt(Math.pow(bX - jX, 2) + Math.pow(bY - jY, 2));
            
            if (jbDist == 0 && jD == bD) {
                sb.append(-1).append('\n');
            } else if (jbDist > jD + bD) {
                sb.append(0).append('\n');
            } else if (jbDist == jD + bD) {
                sb.append(1).append('\n');
            } else if (jbDist < Math.abs(jD - bD)) {
                sb.append(0).append('\n');
            } else if (jbDist == Math.abs(jD - bD)) {
                sb.append(1).append('\n');
            } else if (Math.abs(jD - bD) < jbDist && jbDist < jD + bD) {
                sb.append(2).append('\n');
            }
        }
        System.out.println(sb);
    }
}