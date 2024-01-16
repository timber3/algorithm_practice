import java.util.*;
import java.io.*;

public class Main {
    static int n, d, result, root;
    static int[] arr;
    static boolean[] leaf;
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        nodes = new ArrayList[n];
        leaf = new boolean[n];

        for (int i = 0 ; i < n ; i ++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n ; i ++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == -1) {
                root = i;
                arr[i] = v;
            }
            else {
                nodes[v].add(i);
            }
        }

        d = Integer.parseInt(br.readLine());

        bfs();

        for (int i = 0 ; i < n ; i ++) {
            if (leaf[i]) result ++;
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            int temp = q.poll();
            if (temp != d) {
                boolean flag = false;
                int size = nodes[temp].size();

                for(int i = 0 ; i < size ; i ++) {
                    int nd = nodes[temp].get(i);
                    if (nd != d && nd != -1) {
                        flag = true;
                        q.add(nodes[temp].get(i));
                    }
                }

                if(!flag) {
                    leaf[temp] = true;
                }
            }
        }
    }
}