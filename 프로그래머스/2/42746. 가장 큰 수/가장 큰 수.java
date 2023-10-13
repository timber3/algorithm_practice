import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for (int i = 0 ; i < numbers.length; i ++ ) {
            str[i] = numbers[i] + "";
        }
        
        Arrays.sort(str, (o1 , o2) -> {
            return -(o1 + o2).compareTo(o2 + o1);
        });
        
        for (String s : str) {
            answer += s;
        }
        
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        
        // answer = answer.replace("^[0]+", "0");
        // "[\d]{3}\-[\d]{4}-[\d]{4}"
        // [\w\!\@\#\$\%\^]{8,12}
        
        return answer;
    }
}