import java.util.*;
import java.io.*;

class Solution {
    int n;
    int hour, min;
    int curDay;
    int result;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        n = schedules.length;
        
        for (int i = 0 ; i < n ; i ++) {
            curDay = startday;
            hour = schedules[i] / 100;
            min = schedules[i] % 100;
            int dayCount = 0;
            
            // System.out.println(hour + " " +  min);
            
            for (int j = 0 ; j < 7 ; j ++) {
                if (curDay == 6 || curDay == 7) {
                    curDay %= 7;
                    curDay ++;
                    continue;
                }
                int curHour = timelogs[i][j] / 100;
                int curMin = timelogs[i][j] % 100;
                if (!timeDiffMoreThan10Min(hour, min, curHour, curMin)) {
                    dayCount ++;
                }
                curDay ++;
            }
            
            if (dayCount == 5) result ++;
            dayCount = 0;
        }
        
        return result;
    }
    
    boolean timeDiffMoreThan10Min(int beforeHour, int beforeMin, int afterHour, int afterMin) {
        
        int before = (beforeHour * 60) + beforeMin;
        int after = (afterHour * 60) + afterMin;
        
        if (after - before > 10) return true;
        return false;
    }
}