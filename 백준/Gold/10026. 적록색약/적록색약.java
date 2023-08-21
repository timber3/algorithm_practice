import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        char value;

        public Node(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1, 0,0};
    static char[][] Map;
    static int n;
    static int[][] visited;
    static int area1, area2;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        Map = new char[n][n];
        visited = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                Map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (visited[i][j] == 0){
                    bfs1(i, j);
                    area1 ++;
                }
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (visited[i][j] == 0){
                    bfs2(i, j);
                    area2++;
                }
            }
        }

        System.out.println(area2 + " " + area1);

    }
    // 적록색맹인 사람
    static void bfs1(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, Map[x][y]));
        visited[x][y] = 1;

        while(!q.isEmpty()) {

            Node temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;
            char cval = temp.value;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == 1) {
                    continue;
                }

                if (cval == 'R' || cval == 'G') {
                    if (Map[nx][ny] != 'B'){
                        q.add(new Node(nx, ny, Map[nx][ny]));
                        visited[nx][ny] = 1;
                    }
                }
                else {
                    if (Map[nx][ny] == 'B'){
                        q.add(new Node(nx, ny, Map[nx][ny]));
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }
    // 적록색맹이 아닌 사람
    static void bfs2(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, Map[x][y]));
        visited[x][y] = 1;

        while(!q.isEmpty()) {

            Node temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;
            char cval = temp.value;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == 1) {
                    continue;
                }

                if (Map[nx][ny] == cval){
                    q.add(new Node(nx, ny, cval));
                    visited[nx][ny] = 1;
                }
            }

        }
    }
}
