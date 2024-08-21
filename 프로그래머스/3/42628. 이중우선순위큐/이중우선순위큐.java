import java.util.*;
import java.io.*;

class Solution {
    
    PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> {
        return Integer.compare(b,a);
    });
    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(String[] operations) throws Exception {
        int[] answer = {};
        
        for (int i = 0 ; i < operations.length; i ++) {
            String order = operations[i].substring(0,1);
            int value = Integer.parseInt(operations[i].substring(2, operations[i].length()));
            
            // 삽입 명령
            if (order.equals("I")) {
                maxPq.add(value);
                minPq.add(value);

                if(!map.containsKey(value)) {
                    map.put(value, 1);
                } else {
                    map.put(value, map.get(value) + 1);
                }
            } 
            // 삭제 명령
            else {
                // 최대값 삭제
                if (value == 1) {
                    while (!maxPq.isEmpty()) {
                        int max = maxPq.poll();
                        
                        // 해당 값이 존재하는 값이고 0보다 크면
                        if (map.get(max) > 0) {
                            map.put(max, (map.get(max)-1));
                            break;
                        }
                    }
                } 
                // 최소값 삭제
                else {
                    while (!minPq.isEmpty()) {
                        int min = minPq.poll();
                        
                        // 해당 값이 존재하는 값이고 0보다 크면
                        if (map.get(min) > 0) {
                            map.put(min, (map.get(min)-1));
                            break;
                        }
                    }
                }
            }
        }
        
        // 연산이 끝났다면 q 안에 들어있는지 확인하기
        int maxVal = 0;
        int minVal = 0;
        
        while(!maxPq.isEmpty()) {
            int val = maxPq.poll();
            
            if (map.containsKey(val) && map.get(val) > 0) {
                maxVal = val;
                break;
            }
        }
        
        while(!minPq.isEmpty()) {
            int val = minPq.poll();
            
            if (map.containsKey(val) && map.get(val) > 0) {
                minVal = val;
                break;
            }
        }
        
        answer = new int[]{maxVal, minVal};
        return answer;
    }
}