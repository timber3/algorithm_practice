import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) throws Exception{
        int[] answer = {};
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(arr[0]);
        
        for (int i = 1 ; i < arr.length ; i ++) {
            if (q.peekLast() != arr[i] ) {
                q.add(arr[i]);
            }
        }
        
        int size = q.size();
        
        answer = new int[size];
        
        for (int i = 0 ; i < size ; i ++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}