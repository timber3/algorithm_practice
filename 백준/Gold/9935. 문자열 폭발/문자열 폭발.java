import java.util.*;
import java.io.*;

public class Main {

    static String str, find;
    static ArrayDeque<Character> q1 = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        find = br.readLine();

        for(int i = 0 ; i < str.length() ; i ++) {
            char cur = str.charAt(i);

            // (삭제 해야할 단어의 마지막 글자)랑 같은 글자가 들어갔으면 거기서부터 (앞으로 가면서 단어를 확인한다)
            if (find.charAt(find.length()-1) == cur && q1.size() >= find.length()-1 ) {
                ArrayDeque<Character> q2 = new ArrayDeque<>();
                q2.addFirst(cur);

                for (int j = find.length()-2 ; j >= 0 ; j--) {
                    // exception 방지용
                    if (!q1.isEmpty()) {
                        if (q1.peekLast() == find.charAt(j)) {
                            q2.addFirst(q1.pollLast());
                        } else {
                            while (!q2.isEmpty()) {
                                q1.add(q2.poll());
                            }
                        }
                    }
                }// 여기가 끝나면 q2에 들어가서 문장이 완성됨 or q1 에 들어감
            } else {
                q1.add(cur);
            }
        }

        if(q1.isEmpty()) {
            System.out.println("FRULA");
        } else {
            while(!q1.isEmpty()) {
                sb.append(q1.pollFirst());
            }
            System.out.println(sb);
        }
    }
}