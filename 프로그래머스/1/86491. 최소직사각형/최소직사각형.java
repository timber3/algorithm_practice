import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) throws Exception {
        int answer = 0;
        
        // 가로를 더 긴것들로 채우기
        for (int i = 0 ; i < sizes.length ; i ++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int verMax = 0;
        int horMax = 0;
        
        for (int i = 0 ; i < sizes.length ; i ++) {
            verMax = Math.max(verMax, sizes[i][0]);
            horMax = Math.max(horMax, sizes[i][1]);
        }
        
        return verMax * horMax;
    }
}