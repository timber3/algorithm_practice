import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) throws Exception{
        int[] answer = {};
        int spdIdx = 0;
        int result = 0;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0 ; i < progresses.length ; i ++) {
            q1.add(progresses[i]);
        }
        
        // q1이 빌 때 까지
        while (!q1.isEmpty()) {
            int qSize = q1.size();
            
            for (int i = 0 ; i < qSize ; i++) {
                q2.add(q1.poll() + speeds[i+spdIdx]);
            }
            
            int count = 0;
            
            while(!q2.isEmpty()) {
                if (q2.peek() < 100) {
                    // q2를 꺼내려고 보니까 100 미만이다? (덜 완료됐으니까 다시 q1으로 전부 집어넣기)
                    while(!q2.isEmpty()) {
                        q1.add(q2.poll());
                    }
                } else {
                    // 만약 100 이상이면 꺼내면서 값 증가시켜 주기
                    q2.poll();
                    count++;
                    spdIdx++;
                }
            }
            if (count != 0) {
                list.add(count);
            }
        }
        
        int size = list.size();
        answer = new int[size];
        
        for (int i = 0 ; i < size ; i ++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}