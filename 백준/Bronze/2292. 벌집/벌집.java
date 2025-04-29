import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int cnt = 1; // 층 수 (시작은 1층)
        int range = 1; // 현재 범위의 마지막 숫자 (시작은 1번 방)

        while (n > range) {
            range += 6 * cnt; // 한 층 올라갈 때마다 6개씩 늘어남
            cnt++;
        }

        System.out.println(cnt);
    }
}
