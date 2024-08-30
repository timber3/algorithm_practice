import java.util.*;
import java.io.*;

class Solution {
    int result = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) throws Exception {
        
        visited = new boolean[dungeons.length];
        
        dfs(0, dungeons.length, k, dungeons);
        
        return result;
    }
    
    public void dfs(int cur, int target, int rest, int[][] dungeons) {

        result = Math.max(result, cur);
        
        for (int i = 0 ; i < dungeons.length ; i++) {
            if ( !visited[i] && rest >= dungeons[i][0] ) {

                visited[i] = true;
                dfs(cur + 1, target, rest - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
    }
    
}