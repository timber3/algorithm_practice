import java.util.*;
import java.io.*;

class Solution {
    
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    
    int[][] visited;
    
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) throws Exception {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new int[n][m];
        
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                visited[i][j] = -1;
            }
            
        }
        
        bfs(maps, n, m);
        
        System.out.println(visited[n-1][m-1]);
        
        return visited[n-1][m-1];
    }
    
    public void bfs(int[][] map, int n, int m) {
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.add(new Node(0,0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            int cx = cur.x;
            int cy = cur.y;
            
            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if (map[nx][ny] == 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }
        
    }
}