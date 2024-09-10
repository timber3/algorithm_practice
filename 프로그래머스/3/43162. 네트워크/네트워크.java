import java.util.*;
import java.io.*;

class Solution {
    
    boolean[] visited;
        
    public int solution(int n, int[][] computers) throws Exception {
        
        int count = 0;
        
        visited = new boolean[n];
        
        for (int i = 0 ; i < n ; i ++) {
            if (!visited[i]) {
                bfs(i, computers, n);
                count++;
            }    
        }
        
        return count;
        
    }
    
    public void bfs(int val, int[][] map, int n) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(val);
        visited[val] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0 ; i < n ; i ++) {
                // 연결이 되어있고 방문을 안했던 곳이라면.
                if (!visited[i] && map[cur][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}