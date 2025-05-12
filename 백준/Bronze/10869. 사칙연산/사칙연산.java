import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        // 덧셈
        System.out.println(A + B);
        // 뺄셈
        System.out.println(A - B);
        // 곱셈
        System.out.println(A * B);
        // 몫
        System.out.println(A / B);
        // 나머지
        System.out.println(A % B);
        
        sc.close();
    }
}