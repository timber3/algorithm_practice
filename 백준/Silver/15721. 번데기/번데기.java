import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int turn = 2;
        int idx = 0;
        int count = 0;

        while (true) {
            int[] fixed = {0, 1, 0, 1};
            for (int val : fixed) {
                if (val == target) {
                    count++;
                    if (count == t) {
                        System.out.println(idx);
                        return;
                    }
                }
                idx = (idx + 1) % a;
            }

            for (int i = 0; i < turn; i++) {
                if (target == 0) {
                    count++;
                    if (count == t) {
                        System.out.println(idx);
                        return;
                    }
                }
                idx = (idx + 1) % a;
            }

            for (int i = 0; i < turn; i++) {
                if (target == 1) {
                    count++;
                    if (count == t) {
                        System.out.println(idx);
                        return;
                    }
                }
                idx = (idx + 1) % a;
            }
            turn++;
        }
    }
}