import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, bracket;
    static boolean[] use;
    static int[] bracketNo;
    static char[] arr;
    static Stack<Integer> stack = new Stack<>();
    static HashSet<String> set = new HashSet<>();
    static ArrayList<String> list;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        n = str.length();

        arr = new char[n];
        bracketNo = new int[n];
        int bracketIdx = 1;

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = str.charAt(i);
            if(arr[i] == '(') {
                bracket++;
                bracketNo[i] = bracketIdx;
                stack.push(bracketIdx);
                bracketIdx++;
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    bracketNo[i] = stack.pop();
                }
            }
        }

        use = new boolean[bracket];

        dfs(0);

        list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 1 ; i < list.size() ; i ++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);

    }

    // 몇번째 괄호를 없앨것인지
    static void dfs(int depth) {
        if (depth == bracket) {

            int idx = 0;
            int count = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0 ; i < n ; i ++) {
                if (arr[i] == '(') {
                    if (use[idx]) {
                        result.append(arr[i]);
                    }
                    idx ++;
                } else if (arr[i] == ')') {
                    if (use[bracketNo[i] - 1]) {
                        result.append(arr[i]);
                    }
                } else {
                    result.append(arr[i]);
                }
            }

            set.add(result.toString());

            return;
        }

        dfs(depth + 1);

        use[depth] = true;
        dfs(depth + 1);
        use[depth] = false;

    }
}