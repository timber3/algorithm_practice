import java.util.*;
import java.io.*;

class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, count;
    
    public int solution(int n) throws Exception {
        int answer = 0;
        
        for (int i = n ; i >= 0 ; i--) {
            
            int sum = 0;
            
            for (int j = i ; j >= 0 ; j --) {
                
                sum += j;
                
                if (sum == n) {
                    count ++;
                    sum = 0;
                    break;
                }
                
                if (sum > n) {
                    sum = 0;
                    break;
                }
            }
        }
        
        return count;
    }
}