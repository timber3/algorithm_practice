import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    
    boolean prime[] = new boolean[10_000_000];
    int[] arr;
    int sl;
    int[] result = new int[7];
    boolean[] used = new boolean[7];
    boolean[] check = new boolean[10_000_000];
    
    public int solution(String numbers) {
        
        Arrays.fill(prime, true);
        
        int n = 9_999_999;
        
        prime[0] = prime[1] = false;
        
        for (int i = 2 ; i * i <= n ; i ++) {
            if(prime[i]) {
                for (int j = i*i ; j <= n ; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        sl = numbers.length();
        
        arr = new int[sl];
        
        for (int i = 0 ; i < sl ; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        for (int i = 1; i <= sl ; i ++) {
            dfs(0, i);    
        }
        
        for (int i = 0 ; i < 10_000_000 ; i ++) {
            if(check[i])
                answer++;
        }
        
        return answer;
    }
    
    void dfs(int cnt, int des) {
        
        if (cnt == des) {
            int val = 0;
            int t = 1;
            // 만든 숫자가 소수인지 확인한 후 return
            for (int i = cnt-1 ; i >= 0 ; i --) {
                val += result[i] * t;
                t *= 10;
            }
            
            if (prime[val])
            {
                System.out.print(val);
                check[val] = true;
            }
                
            
            return;
        }
        
        for (int i = 0 ; i < sl; i ++) {
            if (!used[i]) {
                result[cnt] = arr[i];
                used[i] = true;
                dfs(cnt+1, des);
                used[i] = false;
            }

        }
    }
}