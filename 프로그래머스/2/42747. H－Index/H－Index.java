import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) throws Exception {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int n = citations.length;
        answer = n;
        
        while(true) {
            for (int i = 0 ; i < n ; i ++) {
            // answer 보다 크거나 같으면 개수를 센다.
                if ( citations[i] >= answer ) {
                    if (n - i >= answer) {
                        return answer;
                    } else {
                        break;
                    }
                }
            }
            answer --;
            if (answer == 0) {
                return 0;
            }
        }
    }
}