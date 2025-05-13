import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<Integer>[] map;
    static int[] travel;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for (int i = 1 ; i <= n ; i ++) {
            map[i] = new ArrayList<>();
        }
        travel = new int[m];
        visited = new boolean[n+1];

        for (int i = 1 ; i <= n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1 ; j <= n ; j ++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[i].add(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < m ; i ++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        bfs(travel[0]);

        String result = "YES";

        for (int i = 0 ; i < m ; i ++) {
            if (!visited[travel[i]]) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }

    static void bfs(int start) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {

            int cur  = q.poll();

            for (int next : map[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

    }

}