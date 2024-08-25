import java.util.*;
import java.io.*;

class Solution {
    
    boolean[] used;
    int result;
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) throws Exception {
        
        used = new boolean[numbers.length()];
        
        dfs(0, numbers.length(), "", numbers);
        
        // 에라토스테네스의 체
        
        loop : for (int value : set) {
            if (value < 2) continue loop;
            
            // 제곱근까지만 검사하면 됨
            for (int i = 2 ; i <= Math.sqrt(value); i++) {
                if (value % i == 0) {
                    continue loop;
                }
            }
            System.out.println(value);
            result ++;
        }
        

        

        
        
        return result;
    }
    
    public void dfs(int cur, int target, String str, String origin) {
        
        // 1. 만들 수 있는 모든 조합을 만든다.
        // 2. 해당 수가 소수인지 판별한다.
        
        if (cur == target) {
            return;            
        }
        
        for (int i = 0 ; i < origin.length() ; i++) {
            // 해당 숫자를 사용하고 넘어가기
            if (!used[i]) {
                used[i] = true;
                // set에 저장하여 중복을 제거하고 만들 수 있는 모든 경우의 수를 만든다.
                set.add(Integer.parseInt(str + origin.charAt(i)));
                dfs(cur + 1, target, str + origin.charAt(i), origin);
                used[i] = false;
            }
            
            // 해당 숫자를 사용하지 않고 넘어가기
            dfs(cur + 1, target, str, origin);
        }
    }
}