import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int arr[];
    static int[] visited, result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[n];
        visited = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        combi(0, 0);

        System.out.print(sb);
    }

    static void combi(int cnt, int idx){

        if (cnt == m) {
            for (int i = 0 ; i < m; i ++) {
//                System.out.print(result[i] + " ");
                sb.append(result[i] + " ");
            }
            sb.append("\n");
//            System.out.println();
            return;
        }

        for (int i = 0; i < n ; i ++) {
            if(visited[i] != 1){
                visited[i] = 1;
                result[cnt] = arr[i];
                combi(cnt+1, i);
                visited[i] = 0;
            }
        }
    }
}
