import  java.io.*;
import java.nio.Buffer;
import  java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer str;
    static int N, M , K , h,w , rotCnt , cnt =0;
    static int[][] grap;
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        grap = new int [N][M];
        while(K-- > 0) {
            rotCnt = 0;
            str = new StringTokenizer(br.readLine());
            h = Integer.parseInt(str.nextToken());
            w = Integer.parseInt(str.nextToken());
            sticker = new int[h][w];
            for(int i=0;i < h ; i++) {
                str = new StringTokenizer(br.readLine());
                for(int j=0; j < w ;j++) {
                    sticker[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            search(0,0);
        }
        for(int i= 0 ;i < N ;i++) {
            for(int j=0; j < M ;j++) {
                if(grap[i][j] == 1 ) cnt++;
            }
        }
        sb.append(cnt);
        System.out.print(sb);
    }
    public static void search(int x, int y) {
        // 스티커가 grap안에 있는지 확인
        if(y + w >  M || x + h > N) {
            if(x + h > N ) {
                // 시계방향 90도 최대 3번 돌려야함
                if(rotCnt > 2) return;
                else {
                    // 스티커 돌려야함
                    int[][] temp = new int[w][h];
                    for(int i=0;i < h ; i++) {
                        for(int j=0 ; j < w ;j++) {
                            temp[j][h - 1 - i] = sticker[i][j];
                        }
                    }
                    sticker = temp;
                    int a = w;
                    w = h;
                    h = a;
                    rotCnt++;
                    search(0,0);
                }
            }
            else search(x + 1,0);
        }
        else if(canAttach(x, y)) {
            for(int i=0;i < h ;i++) {
                for(int j=0; j < w ;j++) {
                    if(sticker[i][j] == 1) grap[i+ x][j+ y] = 1;
                }
            }
        }
        else search(x,y + 1);
    }
    public static boolean canAttach(int x , int y) {
        for(int i=0;i < h ;i++) {
            for(int j=0; j< w ; j++) {
                if(sticker[i][j] == 1  && grap[i+ x][j + y] == 1) return false;
            }
        }
        return true;
    }
}