import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, 1);
        }
        
        if (map.size() < n/2) {
            answer = map.size();
        } else {
            answer = n/2;
        }
        
        return answer;
    }
}