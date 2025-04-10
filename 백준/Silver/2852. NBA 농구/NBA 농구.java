import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int scoreL = 0, scoreR = 0;
        int prevMin = 0, prevSec = 0;

        int leadMinL = 0, leadSecL = 0;
        int leadMinR = 0, leadSecR = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            String[] time = st.nextToken().split(":");
            int curMin = Integer.parseInt(time[0]);
            int curSec = Integer.parseInt(time[1]);

            int diffMin = curMin - prevMin;
            int diffSec = curSec - prevSec;

            if (diffSec < 0) {
                diffSec += 60;
                diffMin--;
            }

            if (scoreL > scoreR) {
                leadMinL += diffMin;
                leadSecL += diffSec;
                if (leadSecL >= 60) {
                    leadMinL += leadSecL / 60;
                    leadSecL %= 60;
                }
            } else if (scoreR > scoreL) {
                leadMinR += diffMin;
                leadSecR += diffSec;
                if (leadSecR >= 60) {
                    leadMinR += leadSecR / 60;
                    leadSecR %= 60;
                }
            }

            if (team == 1) scoreL++;
            else scoreR++;

            prevMin = curMin;
            prevSec = curSec;
        }

        int diffMin = 48 - prevMin;
        int diffSec = 0 - prevSec;

        if (diffSec < 0) {
            diffSec += 60;
            diffMin--;
        }

        if (scoreL > scoreR) {
            leadMinL += diffMin;
            leadSecL += diffSec;
            if (leadSecL >= 60) {
                leadMinL += leadSecL / 60;
                leadSecL %= 60;
            }
        } else if (scoreR > scoreL) {
            leadMinR += diffMin;
            leadSecR += diffSec;
            if (leadSecR >= 60) {
                leadMinR += leadSecR / 60;
                leadSecR %= 60;
            }
        }

        System.out.printf("%02d:%02d\n", leadMinL, leadSecL);
        System.out.printf("%02d:%02d\n", leadMinR, leadSecR);
    }
}
