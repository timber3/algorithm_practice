#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    int or_num = 0;
    
    for ( int i = 0 ; i < n ; i ++)
    {
        or_num = arr1[i] | arr2[i];
        
        string str = "";
        
        for ( int j = 0 ; j < n ; j ++)
        {
            //cout << "j = " << j << " or_num = " << or_num << endl;
            if ( (or_num % 2) == 0)
            {
                str.push_back(' ');
                //cout << "push' '" << endl;
            }
            else
            {
                str.push_back('#');
                //cout << "push'#'" << endl;
            }
            or_num /= 2;
        }
       
        // 나온 암호를 뒤집어야함.
        
        string temp = "";
        for ( int j = 0 ; j < n ; j ++)
        {
            temp.push_back(str.back());
            str.pop_back();
        }
        
        answer.push_back(temp);
    }    
    
    return answer;
}