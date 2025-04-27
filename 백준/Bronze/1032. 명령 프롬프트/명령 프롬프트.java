import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }

        char[] pattern = files[0].toCharArray();  // 첫 파일을 기준으로 설정

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != files[i].charAt(j)) {
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(new String(pattern));
    }
}