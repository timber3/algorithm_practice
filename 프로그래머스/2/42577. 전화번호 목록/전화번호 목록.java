import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
         boolean answer = true;
        
//         HashMap<String, Integer> map = new HashMap<>();
        
//         for (int i = 0 ; i < phone_book.length ; i ++) {
//             map.put(phone_book[i], i);
//         }
        
//         for (int i = 0 ; i < phone_book.length; i++) {
//             for (int j = 1 ; j < phone_book[i].length(); j++) {
//                 if(map.containsKey(phone_book[i].substring(0,j))) {
//                     answer = false;
//                     return answer;
//                 }
//             }
//         }
        
//         return answer;
        
        Arrays.sort(phone_book);

        for(int i = phone_book.length - 1 ; i > 0; i --) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                answer = false;
                return answer;
            }
        }
        
        return answer;
    }
}