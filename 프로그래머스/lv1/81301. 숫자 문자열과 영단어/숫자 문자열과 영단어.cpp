#include <string>
using namespace std;

int solution(string s) {
    // s = regex_replace(s, regex("zero"), "0");
    // s = regex_replace(s, regex("one"), "1");
    // s = regex_replace(s, regex("two"), "2");
    // s = regex_replace(s, regex("three"), "3");
    // s = regex_replace(s, regex("four"), "4");
    // s = regex_replace(s, regex("five"), "5");
    // s = regex_replace(s, regex("six"), "6");
    // s = regex_replace(s, regex("seven"), "7");
    // s = regex_replace(s, regex("eight"), "8");
    // s = regex_replace(s, regex("nine"), "9"); 
    
    int pos = 0;
    
    for ( int i = 0 ; i < 8 ; i ++)
    {
        if ( (pos = s.find("zero")) != string::npos )
        {
            s.replace(pos, 4, "0");
        }
        if ( (pos = s.find("one")) != string::npos )
        {
            s.replace(pos, 3, "1");
        }
        if ( (pos = s.find("two")) != string::npos )
        {
            s.replace(pos, 3, "2");
        }
        if ( (pos = s.find("three")) != string::npos )
        {
            s.replace(pos, 5, "3");
        }
        if ( (pos = s.find("four")) != string::npos )
        {
            s.replace(pos, 4, "4");
        }
        if ( (pos = s.find("five")) != string::npos )
        {
            s.replace(pos, 4, "5");
        }
        if ( (pos = s.find("six")) != string::npos )
        {
            s.replace(pos, 3, "6");
        }
        if ( (pos = s.find("seven")) != string::npos )
        {
            s.replace(pos, 5, "7");
        }
        if ( (pos = s.find("eight")) != string::npos )
        {
            s.replace(pos, 5, "8");
        }
        if ( (pos = s.find("nine")) != string::npos )
        {
            s.replace(pos, 4, "9");
        }
    }
    
    return stoi(s);
}