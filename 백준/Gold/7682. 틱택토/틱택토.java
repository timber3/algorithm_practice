import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] map;

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            map = new char[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = str.charAt(i * 3 + j);
                }
            }

            boolean result = solve();
            sb.append(result ? "valid\n" : "invalid\n");
        }
        System.out.println(sb);
    }

    public static boolean solve() {
        int Ocount = 0;
        int Xcount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') Ocount++;
                if (map[i][j] == 'X') Xcount++;
            }
        }

        boolean Xwin = isWin('X');
        boolean Owin = isWin('O');

        // X가 먼저 두니까 같거나 1많아야 됨
        if (Ocount > Xcount || Xcount > Ocount + 1) return false;

        // 둘다 이기는 경우는 없음
        if (Xwin && Owin) return false;
        // X가 이겼는데 X가 마지막으로 두면서 이긴게 아니면
        if (Xwin && Xcount != Ocount + 1) return false;
        // O가 이겼는데 O가 마지막으로 두면서 이긴게 아니면
        if (Owin && Xcount != Ocount) return false;

        // 둘다 못이겼는데 돌을 덜 뒀으면 이상한거임
        if (!Xwin && !Owin && Xcount + Ocount != 9) return false;

        return true;
    }

    public static boolean isWin(char c) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
        }
        // 대각선
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;

        return false;
    }
}