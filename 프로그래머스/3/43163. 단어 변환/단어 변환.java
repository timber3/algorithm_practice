import java.util.*;
import java.io.*;

class Solution {
    
    boolean[][] map;
    int[] visited;
    
    public class Node {
        int cur;
        int dis;
        
        public Node (int cur, int dis) {
            this.cur = cur;
            this.dis = dis;
        }
    }
    
    public int solution(String begin, String target, String[] words) throws Exception {
        
        map = new boolean[words.length+1][words.length+1];
        visited = new int[words.length+1];
        
        // begin 단어를 words에 추가
        String[] wholeWords = new String[words.length+1];
        
        wholeWords[0] = begin;
        for(int i = 0 ; i < words.length ; i ++) {
            wholeWords[i+1] = words[i];
        }
        
        // target 과 같은 단어가 없다면 결국 변환 불가.
        boolean keep = false;
        
        for (int i = 0;  i < wholeWords.length ; i ++) {
            if (wholeWords[i].equals(target)) {
                keep = true;
                break;
            }
        }
        
        if(!keep) return 0;
        
        // 변환 가능한지 불가능한지 확인하기
        for (int i = 0 ; i < wholeWords.length ; i ++) {
            for (int j = i ; j < wholeWords.length ; j++) {
                if (i == j) continue;
                
                transWord(i, j, wholeWords);
            }
        }
        
        bfs(wholeWords);
        
        for (int i = 0 ; i < visited.length; i ++) {
            System.out.println(visited[i]);
        }
        
        for (int i = 0 ; i < wholeWords.length ; i++) {
            if (target.equals(wholeWords[i])) {
                return visited[i];
            }
        }
        
        return -1;
    }
    
    public void transWord(int i, int j, String[] wholeWords) {
        
        String a = wholeWords[i];
        String b = wholeWords[j];
        
        int count = 0;
        
        for (int t = 0 ; t < a.length() ; t ++) {
            if (a.charAt(t) != b.charAt(t)) count++;
            
            if (count >= 2) break;
        }
        
        if (count == 1) {
            map[i][j] = true;
            map[j][i] = true;
        }
    }
    
    public void bfs(String[] words) {
        
        for (int i = 0 ; i < visited.length ; i ++) {
            visited[i] = -1;
        }
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.add(new Node(0, 0));
        
        visited[0] = 0;
        
        while(!q.isEmpty()) {
            Node t = q.poll();
            
            int cur = t.cur;
            int dis = t.dis;
            
            for(int i = 0 ; i < words.length; i ++) {
                
                if (map[cur][i] && visited[i] == -1) {
                    q.add(new Node(i, dis + 1));
                    visited[i] = dis+1;
                }
            }
        }
    }
    
}