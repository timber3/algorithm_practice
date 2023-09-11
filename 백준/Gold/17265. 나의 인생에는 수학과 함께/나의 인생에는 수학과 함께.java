import java.io.*;
import java.util.*;

public class Main {
    
    static class Node{
         int x;
         int y;
        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
         
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    static int n;
    static char[][] Map;
    static int Max = Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
    static char[] list;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        Map = new char[n][n];
        list = new char[2*n - 1];
        
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0 ; j < n ; j ++) {
                Map[i][j] = st.nextToken().charAt(0);
            }
        }
        
        list[0] = Map[0][0];
        dfs(0, 0, 1);
        
        System.out.println(Max + " " + Min);
        
    }
    
    static void dfs(int x, int y, int cnt) {
        
        if (cnt == (2*n - 1)) {
            int sum = list[0] - '0';
            
            for(int i = 1 ; i < list.length-1; i++ ) {
                if (list[i]== '+') {
                    sum += list[i+1] - '0';
                } else if (list[i]== '-') {
                    sum -= list[i+1] - '0';
                } else if (list[i]== '*') {
                    sum *= list[i+1] - '0';
                }
            }
            
            Max = Math.max(Max, sum);
            Min = Math.min(Min, sum);
            
            return;
        }
        
        int cx = x;
        int cy = y;
        
        for (int i = 0 ; i < 2; i ++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; 
            // 다음 위치로 이동했을 떄 맵을 벗어나지 않으면
            
            list[cnt] = Map[nx][ny];
            dfs(nx, ny, cnt+1);
            
        }
        
    }
}

