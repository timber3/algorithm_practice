import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 출력
        // System.out.println(n);
        
        int n = nums.length / 2;
        int count = 0;
        boolean[] pockets = new boolean[200001];
        
        for (int i = 0 ; i < nums.length ; i ++) {
            if (!pockets[nums[i]]) {
                pockets[nums[i]] = true;
                count ++;
            }
        }
        
        System.out.println(count);
        
        if (count >= n) {
            answer = n;
        } else {
            answer = count;
        }
        
        return answer;
    }
}