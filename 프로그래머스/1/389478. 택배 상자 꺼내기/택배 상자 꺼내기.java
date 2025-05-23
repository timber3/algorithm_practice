import java.util.*;
import java.io.*;

class Solution {
    
    int[][] map;
    int result = 0;
    
    public int solution(int n, int w, int num) {
        int height = n / w;
        if (n % w != 0) {
            height += 1;
        }
        map = new int[height][w];
        
        int no = 0;
        int dir = -1;
            
        for (int i = height - 1 ; i >= 0 ; i --) {
            dir *= -1;
            if (dir == 1) {
                for (int j = 0 ; j < w ; j ++) {
                    map[i][j] = ++no;
                    if (no == n) break;
                }
            }
            if (dir == -1) {
                for (int j = w-1; j >= 0 ; j --) {
                    map[i][j] = ++no;
                    if (no == n) break;
                }
            }
            if (no == n) break;
            
        }
        
        for (int i = 0 ; i < height ; i ++) {
            for (int j = 0 ; j < w ; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0 ; i < height ; i ++) {
            for (int j = 0 ; j < w;  j ++) {
                if (map[i][j] == num) {
                    if (map[0][j] == 0) {
                        result = i;
                    } else {
                        result = i + 1;
                    }
                }
            }
        }
        
        return result;
    }
}