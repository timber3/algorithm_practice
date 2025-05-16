import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (isTree(i, 0)) {
                        treeCount++;
                    }
                }
            }

            sb.append("Case ").append(caseNumber++).append(": ");
            if (treeCount == 0) sb.append("No trees.\n");
            else if (treeCount == 1) sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(treeCount).append(" trees.\n");
        }

        System.out.print(sb);
    }


    static boolean isTree(int current, int parent) {
        visited[current] = true;

        for (int next : graph[current]) {
            if (next == parent) continue; 
            if (visited[next]) return false; 
            if (!isTree(next, current)) return false;
        }

        return true;
    }
}
