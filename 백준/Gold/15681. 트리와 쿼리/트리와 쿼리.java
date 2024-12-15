import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] tree;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i = 1 ; i <= n ; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n -1 ; i ++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 방향 없는 트리
            tree[u].add(v);
            tree[v].add(u);
        }

        Arrays.fill(visited, -1);
        visited[r] = 1;
        nodeSum(r);

        for (int i = 0 ; i < q ; i ++) {
            sb.append(visited[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    public static int nodeSum(int root) {
        // 본인 노드 개수 추가
        int count = 1;

        for (int i = 0 ; i < tree[root].size(); i ++) {

            // 아직 방문하지 않은 노드가 있다면 하위노드임
            if (visited[tree[root].get(i)] == -1) {
                // 하위노드 개수 추가
                visited[tree[root].get(i)] = 1;
                count += nodeSum(tree[root].get(i));
            }
        }
        visited[root] = count;
        // 하위 노드의 개수를 리턴해야 함.
        return count;
    }
}