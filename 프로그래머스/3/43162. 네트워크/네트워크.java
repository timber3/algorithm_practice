import java.util.*;
import java.io.*;

class Solution {

    static int[] visited;
    
    class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new int[n];
        
        int cnt = 0;

        for (int i = 0 ; i < n ; i ++) {
            
            if (visited[i] == 0) {
                answer ++;

                Queue<Integer> q = new LinkedList<>();    
                visited[i] = 1;

                q.add(i);

                while(!q.isEmpty()) {
                    int cur = q.poll();
                    
                    for (int j = 0 ; j < n ; j++) {
                        if (computers[cur][j] == 1 && visited[j] == 0) { 
                            q.add(j);
                            visited[j] = 1;
                        }
                    }
                }  
            }     
        }
    
        return answer;
    }
}