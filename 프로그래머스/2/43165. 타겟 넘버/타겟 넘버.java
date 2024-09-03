import java.util.*;
import java.io.*;

class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) throws Exception {
        
        dfs(0, numbers.length, 0, target, numbers);
        
        return count;
    }
    
    public void dfs(int cur, int depth, int sum, int target, int[] numbers) {
        
        if (cur == depth) {
            if (sum == target)
                count ++;
            return;
        }
        
        dfs(cur + 1, depth, sum + numbers[cur], target, numbers);
        
        dfs(cur + 1, depth, sum - numbers[cur], target, numbers);
    }
}