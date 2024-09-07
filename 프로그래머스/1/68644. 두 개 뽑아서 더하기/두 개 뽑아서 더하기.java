import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) throws Exception {
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0 ; i < numbers.length ; i++) {
            for (int j = 0 ; j < numbers.length; j ++) {
                if (i == j) {
                    continue;
                }
                else {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        int[] result = new int[set.size()];
        int count = 0;
        
        for (int i : set) {
            result[count++] = i;
        }
        
        Arrays.sort(result);
        
        return result;
    }
}