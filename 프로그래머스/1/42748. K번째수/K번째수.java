import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) throws Exception {
        int[] answer = new int[commands.length];
        
        for (int a = 0 ; a < commands.length ; a ++) {
            
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] arr = new int[j-i+1];
            
            int count = 0;
            for (int t = i - 1; t < j ; t ++) {
                arr[count++] = array[t];
            }
            
            Arrays.sort(arr);
            
            answer[a] = arr[k-1];
            
        }
        
        return answer;
    }
}