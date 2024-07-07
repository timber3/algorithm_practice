import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) throws Exception {
        int answer = 0;
        
        int result = binary(n);
        
        for (int i = n + 1 ; i <= 1_000_000; i ++) {
            if (binary(i) == result) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int binary(int val) {
        int cnt = 0;
        
        while(true) {
            if (val == 0) break;
            cnt += val % 2;
            val /= 2;
        }
        
        return cnt;
    }
    
}