import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) throws Exception {
        int[] answer = new int[2];
        
        int tiles = brown + yellow;
        
        for (int i = 2 ; i <= tiles / 2 ; i ++) {
            if (tiles % i == 0) {
                int j = tiles / i;
                
                if (2*i + 2*j - 4 == brown) {
                    if (i >= j) {
                        answer[0] = i;
                        answer[1] = j;
                    } else {
                        answer[0] = j;
                        answer[1] = i;
                    }
                }
            }
        }
        
        return answer;
    }
}