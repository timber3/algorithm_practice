import java.util.*;
import java.io.*;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) throws Exception {
        int answer = 0;
        
        for (int i = 0 ; i < scoville.length ; i ++) {
            pq.add(scoville[i]);
        }
        
        
        // 가장 맵지 않은 것 + ( 두번째로 맵지 않은 것 * 2)
        // 모든 음식의 스코빌 지수가 K 이상이 될 때 까지 섞는다.
        
        while(pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            int val = pq.poll();
            int val2 = pq.poll();
            pq.add(val + val2 * 2);
            answer ++;
        }
        
        return answer;
    }
    
}