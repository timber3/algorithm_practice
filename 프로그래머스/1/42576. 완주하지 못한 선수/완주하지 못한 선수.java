import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : completion) {
            if (map.get(s) != null) {
                int count = map.get(s);
                map.put(s, ++count);
            } else {
                map.put(s, 1);
            }
        }
        
        for (String s : participant) {
            if (map.get(s) == null || map.get(s) == 0) {
                answer = s;
            } else {
                int count = map.get(s);
                map.put(s, --count);
            }
        }
        
        return answer;
    }
}