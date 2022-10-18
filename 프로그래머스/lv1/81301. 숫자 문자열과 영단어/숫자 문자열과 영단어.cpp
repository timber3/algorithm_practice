#include <string>
#include <iostream>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int pos = 0;
    for ( int i = 0 ; i < 8 ; i ++ )
    {
        if (( pos = s.find("zero")) != string::npos )
        {
            s.replace(pos, 4, "0");
        }
        if (( pos = s.find("one")) != string::npos )
        {
            s.replace(pos, 3, "1");
        }
        if (( pos = s.find("two")) != string::npos )
        {
            s.replace(pos, 3, "2");
        }
        if (( pos = s.find("three")) != string::npos )
        {
            s.replace(pos, 5, "3");
        }
        if (( pos = s.find("four")) != string::npos )
        {
            s.replace(pos, 4, "4");
        }
        if (( pos = s.find("five")) != string::npos )
        {
            s.replace(pos, 4, "5");
        }
        if (( pos = s.find("six")) != string::npos )
        {
            s.replace(pos, 3, "6");
        }
        if (( pos = s.find("seven")) != string::npos )
        {
            s.replace(pos, 5, "7");
        }
        if (( pos = s.find("eight")) != string::npos )
        {
            s.replace(pos, 5, "8");
        }
        if (( pos = s.find("nine")) != string::npos )
        {
            s.replace(pos, 4, "9");
        }
    } 
    
    answer = stoi(s);
    return answer;
}