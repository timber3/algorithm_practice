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


    static int n, m;
    static ArrayList<Integer>[] Map;
    static int[] inDegree;
    static int idx;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map = new ArrayList[n+1];
        for (int i = 1 ; i <= n ; i ++) {
            Map[i] = new ArrayList<>();
        }
        inDegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 방향 그래프
            Map[from].add(to);
            inDegree[to] ++;
        }

        wesang();
    }

    static void wesang() {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1 ; i <= n ; i ++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int val = q.poll();

            System.out.print(val + " ");

            for (int i = 0 ; i < Map[val].size() ; i ++) {
                if (--inDegree[Map[val].get(i)] == 0){
                    q.add(Map[val].get(i));
                }
            }
        }
    }
}
