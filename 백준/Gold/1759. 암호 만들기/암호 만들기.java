import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int l, c;
    static char[] arr;
    static char[] result;
    static int moeum;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new char[c];
        result = new char[l];

        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(arr);
        
        dfs(0, 0, 0);
    }

    static void dfs(int cnt, int idx, int moeum) {
        if (cnt == l) {
            if (moeum > 0 && cnt - moeum >= 2) {
                for (int i = 0; i < l; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = idx ; i < c ; i ++) {
            result[cnt] = arr[i];
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
                dfs(cnt + 1, i + 1, moeum + 1);
            else
                dfs(cnt + 1, i + 1, moeum);
        }
    }
}
