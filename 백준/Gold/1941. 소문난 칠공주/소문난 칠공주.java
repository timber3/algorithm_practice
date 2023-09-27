import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static boolean[] visited;
    static int[] selected;
    static int count;

    public static void main(String[] args) throws IOException {


        map = new char[5][5];
        visited = new boolean[25];
        selected = new int[7];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0 ; j < 5 ; j ++)
            {
                map[i][j] = str.charAt(j);
            }
        }

        combi(0, 0, 0);

        System.out.println(count);

    }

    static void combi(int val, int cur, int ycnt) {
    	
    	if (ycnt >= 4)
    		return;
    	
        if (cur == 7) {
            if (bfs())
                count ++;
            return;
        }


        for (int i = val; i < 25 ; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cur] = i;
                if (map[i/5][i%5] == 'Y') {
                    combi(i+1, cur+1, ycnt+1);
                } else {
                    combi(i+1, cur+1, ycnt);
                }
                visited[i] = false;
            }
        }
    }
    static boolean bfs() {
        boolean[] temp = new boolean[25];

        for (int i = 0; i < 7 ; i++) {
            temp[selected[i]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(selected[0]);
        temp[selected[0]] = false;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int cx = cur/5;
            int cy = cur%5;

            for (int i = 0 ; i < 4 ; i ++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || !temp[(nx*5)+ny])
                    continue;

                temp[(nx*5)+ny] = false;
                q.add((nx*5)+ny);
            }
        }

        for (int i = 0 ; i < 7 ; i++) {
            // true 가 있다면 = 이어지지 않았다면
            if (temp[selected[i]]) {
                return false;
            }
        }

        return true;
    }

}