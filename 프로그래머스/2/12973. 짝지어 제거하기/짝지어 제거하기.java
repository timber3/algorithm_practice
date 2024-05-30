import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        ArrayDeque<Character> q = new ArrayDeque<>();
        
        for (int i = 0 ; i < s.length(); i ++) {
            
            char curChar = s.charAt(i);
            
            if (!q.isEmpty() && (q.getLast() == curChar)) {
                q.pollLast();
            } else {
                q.add(curChar);
            }
        }
        
        if (q.size() == 0) answer = 1;

        return answer;
    }
}