import java.util.*;
import java.io.*;

public class Main {

   static String str;
   static String[] temp;

   static ArrayDeque<String> stack = new ArrayDeque<>();

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      str = br.readLine();
      temp = str.split("");

      for (int i = 0 ; i < str.length(); i++) {
         if ("(".equals(temp[i]) || "[".equals(temp[i])) {
            stack.add(temp[i]);
         } else {
            {
               long sum = 0;
               // 만약에 닫는 괄호가 나왔으면 여는 괄호를 만날 때 까지
               while(!stack.isEmpty() && !stack.peekLast().equals("(") && !stack.peekLast().equals("[")) {
                  sum += Integer.parseInt(stack.pollLast());
               }

               // 0 출력
               if (stack.isEmpty() || (stack.peekLast().equals("[") && temp[i].equals(")")) || (stack.peekLast().equals("(") && temp[i].equals("]"))) {
                  System.out.println(0);
                  return;
               }

               if (sum == 0)
                  sum ++;
               
               if (temp[i].equals(")")) {
                  stack.pollLast();
                  // 숫자 -> char
                  stack.add(String.valueOf(sum * 2));
               } else {
                  stack.pollLast();
                  stack.add(String.valueOf(sum * 3));
               }
            }
         }
      }
      
      int result = 0;
      while(!stack.isEmpty()) {
         String cur = stack.peekLast();
         if (cur.equals("]") || cur.equals(")") || cur.equals("(") || cur.equals("[")) {
            System.out.println(0);
            return;
         } else {
            result += Integer.parseInt(cur);
            stack.pollLast();
         }
      }
      
      System.out.println(result);
   }
}