import java.util.*;
import java.io.*;

class Solution {
    
    boolean[][] map;
    
    public int solution(int n, int[][] wires) throws Exception {
        
        map = new boolean[n+1][n+1];
        
        for (int i = 0 ; i < wires.length ; i ++) {
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        
        int result = 101;
        
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j ++) {
                // 연결 되어 있다면.
                if (map[i][j]) {
                    // 전력을 하나씩 끊기
                    map[i][j] = false;
                    map[j][i] = false;
                    
                    result = Math.min(bfs(n), result);

                    map[i][j] = true;
                    map[j][i] = true;
                }
            }
        }
        
        return result;
    }
    
    public int bfs(int n) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 그냥 아무 노드 넣어서 몇개 이어져있나 확인하기
        q.add(1);
        
        boolean[] visited = new boolean[n+1];
        
        visited[1] = true;
        
        int count = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 1 ; i <= n ; i ++) {
                if (map[cur][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count ++;
                }
            }
        }
        
        return Math.abs((n - count) - count);
        
    }
}