import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, t, result;
    static int[] know, visited;
    static int[][] Map;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        know = new int[t];
        visited = new int[51];
        Map = new int[51][51];
        party = new ArrayList[m];
        for (int i = 0 ; i < m ; i ++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < t ; i ++) {
            know[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            int start = 0;
            for (int j = 0 ; j < cnt ; j ++) {
                int val = Integer.parseInt(st.nextToken());
                party[i].add(val);
                if (j == 0) {
                    start = val;
                } else {
                    Map[start][val] = 1;
                    Map[val][start] = 1;
                }
            }
        }

        bfs();

        for (int i = 0 ; i < m; i ++) {
            boolean cnt = true;
            for (int j = 0; j < party[i].size(); j++) {
                if (visited[party[i].get(j)] == 1) {
                    cnt = false;
                    break;
                }
            }

            if (cnt)
                result++;
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < t ; i++) {
            q.add(know[i]);
            visited[know[i]] = 1;
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 50 ; i++) {
                if (Map[cur][i] == 1 && visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
