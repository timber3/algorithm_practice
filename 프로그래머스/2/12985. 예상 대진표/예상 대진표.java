import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        // 같은 쪽에 속해있다면
        int depth = 0;
        double rest = n;
        
        while(rest != 1) {
            rest = rest / 2;
            depth ++;
        }
        
        n /= 2;
        
        for (int i = depth ; i > 1 ; i --) {
            
            int res = sameSide(n, a, b);
            
            if(res == 0) {
                answer= i;
                break;
            } else if (res == 1) {
                n -= Math.pow(2, i-2);
            } else if (res == 2) {
                n += Math.pow(2, i-2);
            }
        }
        
        System.out.println(answer);
        
        
        return answer;
    }
    
    private int sameSide(int n, int a, int b) {
        int isSameSide = 0;
        if ( a <= n && b <= n ) {
            isSameSide = 1;
        }
        if ( a > n && b > n ) {
            isSameSide = 2;
        }
        return isSameSide;
    }
}