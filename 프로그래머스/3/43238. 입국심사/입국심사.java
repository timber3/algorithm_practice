import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) throws Exception {
        // 모든 사람이 심사를 받는데 걸리는 시간의 최대값을 구한다.
        Arrays.sort(times);
        // 오름차순으로 정렬한 후 (가장 오래 걸리는 시간의 심사대 * 사람) 이 최대값이 될 것이다.
        // 해당 값은 소요되는 시간의 최대치로 이분탐색의 right가 된다.
        long right = times[times.length-1] * (long)n;
        long left = 0;
        long answer = 0;
        
        // 이분탐색 시작
        while(left <= right) {
            // mid 는 소요되는 시간을 확인하기 위한 기준점
            long mid = (left + right) / 2;
            // mid(소요되는 시간)를 각 심사관마다 소요되는 시간으로 나누면 그 시간동안 몇명의 사람들을 받을 수 있는지 알 수 있음
            // 그 만큼의 사람 수 보다 적다면 mid가 커져야 하고 많다면 mid가 작아져야 한다.
            // 왜냐하면 최소 시간을 구해야하기 때문.
            long available = 0;
            for (int i = 0 ; i < times.length ; i ++) {
                available += mid/times[i];
            }
            
            // 만약 받을 수 있는 사람이 전체 사람보다 적으면 mid를 더 키워야 함
            if (available < n) {
                left = mid + 1;
            }
            // 만약 받을 수 있는 사람이 전체 사람보다 많거나 같으면 시간을 더 줄일 수 있을지도 모르므로
            // answer를 계속 최신화 해줘야 함.
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}