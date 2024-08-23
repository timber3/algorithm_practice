import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) throws Exception {
        String answer = "";
        
        String[] arrs = new String[numbers.length];
        
        for (int i = 0 ; i < numbers.length ; i ++) {
            arrs[i] = numbers[i] + "";
        }
        
        Arrays.sort(arrs, (a,b) -> {
            return (b + a).compareTo(a + b);
        });
        
        for (int i = 0 ; i < arrs.length ; i ++) {
            if (answer.length() == 0 && arrs[i].equals("0")) {
                answer = "0";
                break;
            }
            answer += arrs[i];
        }
        
        return answer;
    }
}