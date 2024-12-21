import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        // 우선 각자가 대장 노드 임.
        for (int i = 0 ; i < n ; i ++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b를 union 했을 때 사이클이 형성된다면 단계 출력하고 종료
            if (!union(a,b)) {
                System.out.println(i+1);
                return;
            }
        }

        // 여기까지 왔으면 아직 게임 진행 중
        System.out.println(0);

    }

    public static int find(int node) {
        // 내가 대장 노드가 아니라면
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        } else {
            // rootA == rootB -> 대장 노드가 같을 경우 합치면 사이클이 생겨버림
            return false;
        }

    }
}