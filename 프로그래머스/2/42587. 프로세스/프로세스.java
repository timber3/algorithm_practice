import java.util.*;
import java.io.*;

class Solution {
    
    class Process {
        int priority;
        boolean needToKnow;
        
        Process (int priority, boolean needToKnow) {
            this.priority = priority;
            this.needToKnow = needToKnow;
        }
    }
    public int solution(int[] priorities, int location) throws Exception {
        int answer = 0;
        
        ArrayDeque<Process> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            return b-a;
        });
        
        for (int i = 0 ; i < priorities.length ; i++) {
            if (i == location) {
                q.add(new Process(priorities[i], true));
            } else {
                q.add(new Process(priorities[i], false));
            }
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            
            Process cur = q.poll();
            
            // 우선순위가 낮다면 다시 넣기
            if (cur.priority != pq.peek()) {
                q.add(cur);
            } else {
                // 우선순위가 최고가 맞다면 일단 pq에 맞는 애를 꺼냈기 때문에 pq에서 제거해주기
                pq.poll();
                answer++;
                // 그리고 우리가 찾는 애가 맞다면 리턴해주기
                if (cur.needToKnow) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}