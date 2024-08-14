import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) throws Exception {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] s : clothes) {
            if (map.get(s[1]) == null) {
                map.put(s[1], 1);
            } else {
                int count = map.get(s[1]);
                map.put(s[1], ++count);
            }
        }
        
        int result = 1;
        
        for (String key : map.keySet()) {
            result *= map.get(key) + 1;
        }
        
        answer = result - 1;
        
        return answer;
    }
}