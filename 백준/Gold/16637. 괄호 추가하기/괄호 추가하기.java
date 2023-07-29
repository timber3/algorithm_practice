import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    static int n;
    static String input;
    static char[] values;
    static int Max = Integer.MIN_VALUE;

    static int cal(int a ,int b, char op)
    {
        switch(op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
        }
        return 0;
    }

    static void dfs(int cur, int sum)
    {
        if (cur >= n)
        {
            Max = Math.max(Max, sum);
            return;
        }

        // 1 + 2 - 3 x 4 + 5 - 6
        // 괄호를 안 치고 넘어가기
        // 괄호를 안 치면 앞에 앞 숫자랑 뒷 숫자랑 계산해서 넘김

        dfs(cur + 2, cal(sum, values[cur] - '0', values[cur - 1]) );

        // 괄호를 치고 넘어가기
        // 괄호 먼저 계산 ( 마지막 숫자는 괄호 칠 수 없으니까 빼고 ) 후 앞에꺼 계산
        if (cur + 2 <= n){
            int temp = cal(values[cur] - '0' , values[cur + 2] - '0', values[cur+1]);
            // 괄호 계산 후 앞에꺼랑 계산, 인덱스는 괄호까지 계산 했으니 4칸 뜀
            dfs(cur + 4, cal(sum, temp , values[cur-1]));
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        n = sc.nextInt();
        sc.nextLine();
        input = sc.nextLine();
        values = new char[n];

        values = input.toCharArray();

        // 두 번 째 숫자부터 괄호를 칠지 말지 결정 하므로
        dfs(2, values[0] - '0');

        System.out.println(Max);

    }
}
