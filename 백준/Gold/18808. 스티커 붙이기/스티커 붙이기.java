import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, count;
    static int[][] map;
    static ArrayList<int[][]> stickers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < k ; i ++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[R][C];

            for (int r = 0 ; r < R ; r ++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0 ; c < C ; c ++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(sticker);
        }

        //input

        // 1. 스티커를 왼쪽 위부터 오른쪽으로 그리고 아래로 대보면서 붙인다. (모든 격자 순회 해야하나?)

        // 2. 못 붙인다면 rotate 한 번 해서 전부 대본다.
        for (int[][] sticker: stickers) {

            boolean sticked = false;

            // 4방향으로 돌려야 할 수 있음.
            loop: for (int k = 0 ; k < 4 ; k ++) {
                int r = sticker.length;
                int c = sticker[0].length;

                for (int i = 0 ; i < n ; i ++) {
                    for (int j = 0 ; j < m ; j ++) {
                        // 스티커의 사이즈를 고려하여 붙일 수 있는지 확인
                        if (i + r <= n && j + c <= m ) {
                            if (canStick(i, j, sticker)) {
                                stick(i, j, sticker);
                                sticked = true;
                                break loop;
                            }
                        }
                    }
                }

                // for문을 전부 돌았는데도 stick을 하지 못했다면
                if (!sticked) {
                    sticker = rotate(sticker);
                } else {
                    break;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (map[i][j] == 1) {
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    // 오른쪽으로 90도 회전 후 리턴
    static int[][] rotate(int[][] sticker) {
        int n = sticker.length;
        int m = sticker[0].length;

        int[][] rotatedSticker = new int[m][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                rotatedSticker[j][n - 1 - i] = sticker[i][j];
            }
        }

        return rotatedSticker;
    }

    // 스티커 붙일 왼쪽 위 좌표, 스티커
    // 스티커가 모눈종이 안에 들어가는지 체크 필요 (들어오기 전에)
    static boolean canStick(int x, int y, int[][] sticker) {

        int r = sticker.length;
        int c = sticker[0].length;

        // 스티커를 붙일 자리에 모눈종이에 뭐가 붙어있으면 안됨
        for (int i = x ; i < x + r ; i ++) {
            for (int j = y ; j < y + c ; j ++) {
                if (sticker[i - x][j - y] == 1 && map[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static void stick(int x, int y, int[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int i = x ; i < x + r ; i ++) {
            for (int j = y ; j < y + c ; j ++) {
                if (sticker[i - x][j - y] == 1) {
                    map[i][j] = 1;
                }
            }
        }
    }

}