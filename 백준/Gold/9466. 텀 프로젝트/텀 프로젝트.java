import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T, n, count;
    static int[] map;
    static boolean[] visited;
    static boolean[] hasTeam;
    static boolean[] done;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());
            count = 0;

            map = new int[n+1];
            hasTeam = new boolean[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1 ; i <= n ; i ++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1 ; i <= n ; i++) {
                // 자기 자신을 가르키는지 확인하기
                if(!done[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int i) {
        if(visited[i]){
            done[i] = true;
            count++;
        }else{
            visited[i] = true;
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!done[map[i]]){
            dfs(map[i]);
        }

        visited[i] = false;
        done[i] = true;
    }
}