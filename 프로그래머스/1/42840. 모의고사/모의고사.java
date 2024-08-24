import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) throws Exception {
        int[] one = {1,2,3,4,5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answer = {};
        
        int oneSum = 0;
        int twoSum = 0;
        int threeSum = 0;
        //?
        
        for (int i = 0 ; i < answers.length; i ++) {
            if (one[i%5] == answers[i])
                oneSum++;
        }
        
        for (int i = 0 ; i < answers.length; i ++) {
            if (two[i%8] == answers[i])
                twoSum++;
        }
        
        for (int i = 0 ; i < answers.length; i ++) {
            if (three[i%10] == answers[i])
                threeSum++;
        }
        
        int max = Math.max(Math.max(oneSum, twoSum),threeSum);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if (max == oneSum) {
            result.add(1);
        }
        
        if (max == twoSum) {
            result.add(2);
        }
        
        if (max == threeSum) {
            result.add(3);
        }
        
        answer = new int[result.size()];
        
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}