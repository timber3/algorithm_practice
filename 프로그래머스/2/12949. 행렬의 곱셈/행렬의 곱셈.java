import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) throws Exception {
        
        int row1 = arr1.length;
        int col2 = arr2[0].length;
        
        int resultRow = row1;
        int resultcol = col2;
        
        int[][] result = new int[resultRow][resultcol];
        
        for(int i = 0 ; i < resultRow ; i ++ ){
            for(int j = 0 ; j < resultcol ; j ++ ){
                int sum = 0;
                for(int k = 0; k < arr2.length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
        
    }
}