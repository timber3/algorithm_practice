import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, T, des;
    static int max;
    static int[] time, sum;
    static int[] indegree;
    static ArrayList<Integer>[] next;

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            st = new StringTokenizer(br.readLine());

            max = Integer.MIN_VALUE;
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            time = new int[n+1];
            sum = new int[n+1];
            next = new ArrayList[n+1];
            indegree = new int[n+1];

            for (int i = 1 ; i <= n ; i ++) {
                next[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1 ; i <= n ; i ++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 해당 타겟에서 출발해서 루트까지 거꾸로 올라갈 수 있게
            for (int i = 0 ; i < k ; i ++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int nxt = Integer.parseInt(st.nextToken());

                next[pre].add(nxt);
                // 진입차수 ++
                indegree[nxt]++;
            }

            des = Integer.parseInt(br.readLine());
            //input

            ArrayDeque<Integer> q = new ArrayDeque<>();

            // q에 진입차수가 0인 노드들 건물을 먼저 넣기 ( 건설 기준이 충족된 애들 )
            for (int i = 1 ; i <= n ; i ++) {
                if (indegree[i] == 0 ) {
                    sum[i] = time[i];
                    q.add(i);
                }
            }

            while(!q.isEmpty()) {
                int cur = q.poll();

                for (int nxt : next[cur]) {
                    sum[nxt] = Math.max(sum[nxt], time[nxt] + sum[cur]);
                    indegree[nxt]--;

                    if (indegree[nxt] == 0) {
                        q.add(nxt);
                    }
                }
            }

            System.out.println(sum[des]);
        }
    }
}