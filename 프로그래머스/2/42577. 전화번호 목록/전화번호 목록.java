import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) throws Exception{
        
        HashSet<String> set = new HashSet<>();
        
        Arrays.sort(phone_book);
        
        for (String s : phone_book) {
            for (int i = 0 ; i <= s.length(); i ++) {
                if (set.contains(s.substring(0,i))) {
                    return false;
                }
            }
            set.add(s);
        }
        
        return true;
    }
}