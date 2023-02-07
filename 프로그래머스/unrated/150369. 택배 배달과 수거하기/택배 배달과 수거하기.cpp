#include <bits/stdc++.h>

using namespace std;
vector<int> del;
vector<int> pic;
int des;
int des_del;
int des_pic;
int rest_del;
int can_pick;
long long sum = 0;

    void find_des()
    {   
        for (int i = des; i >= 0 ; i --)
        {
            if(del[i] > 0 || pic[i] > 0)
            {
                des = i;
                return;
            }
        }
        
        des = -1;
    }

    void deliver()
    {
        for(int i = des_del; i >= 0 ; i --)
        {
            // 배달할 상자의 양 >= 배달할 수 있는 상자의 양
            if (del[i] >= rest_del)
            {
                del[i] -= rest_del;
                rest_del = 0;
                des_del = i;
                return;
            }
            else
            {
                rest_del -= del[i];
                del[i] = 0;
            }
        }
        rest_del = 0;
    }

    void recycle()
    {
        for(int i = des_pic; i >= 0 ; i --)
        {
            // 수거할 상자의 양 >= 수거할 수 있는 양
            if (pic[i] >= can_pick)
            {
                pic[i] -= can_pick;
                can_pick = 0;
                des_pic = i;
                return;
            }
            else
            {
                can_pick -= pic[i];
                pic[i] = 0;
            }
        }
        can_pick = 0;
    }

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = -1; 
    
    des = n-1;
    des_del = des;
    des_pic = des;
    
    del = deliveries;
    pic = pickups;
    
    while(1)
    {
        find_des();
        
        if(des == -1)
            break;
        
        rest_del = cap;
        can_pick = cap;
        
        sum += (des+1) * 2;
        
        deliver();
        recycle();
    }
    
    answer = sum;
    
    return answer;
}