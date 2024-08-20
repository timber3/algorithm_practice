import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) throws Exception {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> { return o1[1] - o2[1]; });
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int idx=0, cur=jobs[0][0];
        
        while(idx < jobs.length || !pq.isEmpty()){
            
            while(idx < jobs.length && jobs[idx][0] <= cur){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                cur = jobs[idx][0];
                pq.add(jobs[idx++]);
            }
            
            int[] process = pq.poll();
            
            // 시간은 프로세스의 동작 시간 만큼 넣어주기
            cur += process[1];
            answer += cur-process[0];
        }
        
        return answer/jobs.length;
    }
}