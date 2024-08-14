import java.util.*;
import java.io.*;

class Solution {
    
    class Index {
        Integer play;
        Integer index;
        
        Index (int play, int index) {
            this.play = play;
            this.index = index;
        }
    }
    
    class Info {
        Integer sum;
        
        PriorityQueue<Index> pq;
        
        public Info (int sum) {
            this.sum = sum;
            this.pq = new PriorityQueue<>( (a, b) -> {
                return b.play - a.play;
            });
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) throws Exception{
        int[] answer = {};
        
        HashMap<String, Info> map = new HashMap<>();
        
        // 장르별 합계를 먼저 계산
        for (int i = 0 ; i < genres.length ; i ++) {
            // 이미 해당 장르에 노래가 들어가있다면
            if (map.containsKey(genres[i])) {
                // 합산 추가해주기
                Info temp = map.get(genres[i]);
                temp.sum += plays[i];
                temp.pq.add(new Index(plays[i], i));
            } else {
                // 해당 장르에 노래가 없다면 새로 Info 객체 만들어주고 그 안에 sum 넣어주기
                map.put(genres[i], new Info(plays[i]));
                // 해당 Info 객체의 pq에도 값을 넣어주기
                Info temp = map.get(genres[i]);
                temp.pq.add(new Index(plays[i], i));
                
            }
        }
        
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> {
            return b.sum - a.sum;
        });
        
        for (String s : map.keySet()) {
            pq.add(map.get(s));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            Info temp = pq.poll();
            // System.out.println(temp.sum);
            for (int i = 0 ; i < 2 ; i ++) {
                if (temp.pq.isEmpty()) {
                    break;
                }
                result.add(temp.pq.poll().index);
            }
        }
        
        answer = new int[result.size()];
        
        for (int i = 0 ; i < result.size() ; i ++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}