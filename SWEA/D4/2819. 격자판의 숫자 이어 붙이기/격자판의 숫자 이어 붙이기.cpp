#include <bits/stdc++.h>
 
using namespace std;
 
char Map[5][5];
 
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1, 0,0 };
 
int cx;
int cy;
 
map<string, int> m;
string str = "";
 
typedef struct node {
    int x;
    int y;
};
 
void dfs(int cnt)
{
    if (cnt == 7)
    {
        // vector에 넣기 (중복 검사)
        m.insert({ str, 0 });
        return;
    }
 
    for (int i = 0; i < 4; i++)
    {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
 
        if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
            continue;
 
        str = str + Map[nx][ny];
        cx += dx[i];
        cy += dy[i];
        dfs(cnt + 1);
        str.pop_back();
        cx -= dx[i];
        cy -= dy[i];
 
    }
 
}
 
int main()
{
    int t;
 
    cin >> t;
 
    for (int T = 0; T < t; T++)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                cin >> Map[i][j];
            }
        }
 
 
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                cx = i;
                cy = j;
                dfs(0);
            }
        }
         
        cout << "#" << T+1 << " " << m.size() << '\n';
 
        m.clear();
    }
 
    return 0;
}