import java.util.*;
class Solution {
    List<int[]> list = new ArrayList<>();
    
    public List<int[]> solution(int n) {
        
        //하노이의 탑 원리
        // N개의 원판이 존재한다고가정
        // h(1, 2, 3 ,N) = h(1,3,2,N-1) + 1 (가장큰원판 깔기) + h(2,1,3,N-1)
        // 점화식 구현 
        
        h(1,2,3,n);
            
        return list;
    }
    
    public void h(int s, int m, int e,int n){
        int[] move = {s,e};
        
        if(n==1){
            list.add(move);
            return;
        }
        else{
            h(s,e,m,n-1);
            list.add(move);
            h(m,s,e,n-1);
        }
    }
}