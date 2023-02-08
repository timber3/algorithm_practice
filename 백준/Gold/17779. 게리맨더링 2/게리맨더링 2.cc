#include<iostream>
#include<algorithm>
 
#define endl "\n"
#define MAX 20
using namespace std;
 
struct COORD
{
    int x;
    int y;
};
 
int N, Answer = 987654321;
int MAP[MAX][MAX];
int Label[MAX][MAX];
COORD Pos[4];
 
int Min(int A, int B) { if (A < B) return A; return B; }
 
void Input()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> MAP[i][j];
        }
    }
}
 
bool CanMakeLine(int x, int y, int d1, int d2)
{
    /* 선거구의 경계선을 그릴 수 있는지 체크해보는 함수. 
       - 각 꼭짓점의 범위를 생각하면 된다.
       - 헷갈린다면, 문제에서 주어진 조건을 체크해보면 된다.
    */
    if (x + d1 >= N || y - d1 < 0) return false;
    if (x + d2 >= N || y + d2 >= N) return false;
    if (x + d1 + d2 >= N || y - d1 + d2 >= N) return false;
    if (x + d2 + d1 >= N || y + d2 - d1 < 0) return false;
 
    return true;
}
 
void Calculate()
{
    /* 실제로 인구수를 계산하고 최소값을 구하는 함수 */
    int Sum[6] = { 0, 0, 0, 0, 0, 0};
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            Sum[Label[i][j]] = Sum[Label[i][j]] + MAP[i][j];
        }
    }
    sort(Sum, Sum + 6);
    int Diff = Sum[5] - Sum[1];
    Answer = Min(Answer, Diff);
}
 
void Labeling(int a, int b, int c, int d)
{
    /* Pos[0] , Pos[1], Pos[2], Pos[3] 은 설명대로 꼭짓점을 의미합니다. */
 
    /* 선거구의 번호를 붙이는 함수. 
       1. 가장 먼저 모든 선거구를 '5'번으로 설정 */
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            Label[i][j] = 5;
        }
    }
 
    /* 1번 선거구 설정 과정. 
       - 1번 선거구는 0행부터 1번 꼭짓점의 x좌표 행 까지 
       - 1번 선거구는 0열부터 0번 꼭짓점의 y좌표 열 까지.
       - 이 과정에서 행의 값이, 0번 꼭짓점의 x좌표보다 크거나 같아지는 순간, 표시해야 하는 열의 갯수가 한칸씩 줄어든다. */
    int SubArea = 0;
    for (int i = 0; i < Pos[1].x; i++)
    {
        if (i >= Pos[0].x) SubArea++;
        for (int j = 0; j <= Pos[0].y - SubArea; j++)
        {
            Label[i][j] = 1;
        }
    }
 
    /* 2번 선거구 설정 과정.
       - 2번 선거구는 0행부터 2번 꼭짓점의 x좌표 행 까지.
       - 2번 선거구는 0번 꼭짓점의 y좌표 열 부터 맵의 끝까지.
       - 이 과정에서 행의 값이, 0번 꼭짓점의 x좌표 행보다 커지면, 표시해야 하는 열의 갯수가 한칸씩 줄어든다. */
    int PlusArea = 0;
    for (int i = 0; i <= Pos[2].x; i++)
    {
        if (i > Pos[0].x) PlusArea++;
        for (int j = Pos[0].y + 1 + PlusArea; j < N; j++)
        {
            Label[i][j] = 2;
        }
    } 
 
    /* 3번 선거구 설정 과정.
        - 3번 선거구는 N - 1행부터 1번 꼭짓점의 x좌표 행까지.
        - 3번 선거구는 0열부터 3번 꼭짓점의 y좌표 열 까지.
        - 이 과정에서, 행의 값이 3번 꼭짓점의 x좌표 값보다 작아지면, 표시해야 하는 열의 갯수가 한칸씩 줄어든다.*/
    SubArea = 0;
    for (int i = N - 1; i >= Pos[1].x; i--)
    {
        if (i < Pos[3].x) SubArea++;
        for (int j = 0; j < Pos[3].y - SubArea; j++)
        {
            Label[i][j] = 3;
        }
    }
 
    /* 4번 선거구 설정 과정.
       - 4번 선거구는 N - 1행부터 2번 꼭짓점의 x좌표 행까지.
       - 4번 선거구는 3번 꼭짓점의 y좌표 열부터, 맵의 끝까지.
       - 이 과정에서, 행의 값이 3번 꼭짓점의 x좌표 값보다 작아지면, 표시해야 하는 열의 갯수가 한칸씩 줄어든다. */
    PlusArea = 0;
    for (int i = N - 1; i > Pos[2].x; i--)
    {
        if (i <= Pos[3].x) PlusArea++;
        for (int j = Pos[3].y + PlusArea; j < N; j++)
        {
            Label[i][j] = 4;
        }
    }
 
    Calculate();
}
 
void Solution()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 1; j < N; j++)
        {
            for (int D1 = 1; D1 <= j; D1++)            // D1의 범위는 1 부터 현재 y좌표 까지 
            {
                for (int D2 = 1 ; D2 < N - j; D2++)    // D2의 범위는 현재 y좌표부터 맵의 가로길이 끝까지 남은 칸수
                {
                    if (CanMakeLine(i, j, D1, D2) == true)        // 위의 범위만으로 무조건 선거구를 그릴 수 없기 때문에 선거구를 그릴 수 있는지 체크하는 함수.
                    {
                        Pos[0].x = i; Pos[0].y = j;
                        Pos[1].x = i + D1; Pos[1].y = j - D1;
                        Pos[2].x = i + D2; Pos[2].y = j + D2;
                        Pos[3].x = i + D1 + D2; Pos[3].y = j - D1 + D2;
                        Labeling(i, j, D1, D2);
                    }
                }
            }
        }
    }
    cout << Answer << endl;
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}