import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    // 못풀어서 해답을 봤더니 100을 넣으면 이걸 다 돌리는게 아니라고 함..
    // 원판을 3개 넣으면 움직이는 횟수는 2^3 - 1 이라고 함.
    // 결국 움직이는 횟수는 2^n - 1로 한번에 구한 후 하노이 탑을 돌리면 됨.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
        BigInteger bi = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        sb.append(bi + "\n");

        if (n <= 20){
            hanoi(n, 1, 2, 3);
        }

        System.out.println(sb);
    }

    // n개 원판, start 기둥, 임시 course 기둥, 목적 des 기둥

    static void hanoi(int n, int start , int course, int des) {
        if (n == 0)
            return;

        hanoi(n-1, start, des, course);
        sb.append(start + " " + des + "\n");
        hanoi(n-1, course, start, des);

    }
}
