#include <iostream>
#include <vector>
#define MAX 11
using namespace std;

int map[MAX][MAX];
bool visit[MAX][MAX];
vector<pair<int, int> > v;
int n, blackAns, whiteAns;

// 비숍을 둘 수 있는지 확인
bool isPossible(int x, int y) {
    // 왼쪽 위 대각선 이동
    int nx = x - 1;
    int ny = y - 1;
    while (nx >= 0 && ny >= 0) {
        // 이미 비숍을 둔 곳이라면 false를 리턴
        if (visit[nx][ny]) return false;
        nx--;
        ny--;
    }

    // 오른쪽 위 대각선 이동
    nx = x - 1;
    ny = y + 1;
    while (nx >= 0 && ny < n) {
        // 이미 비숍을 둔 곳이라면 false를 리턴
        if (visit[nx][ny]) return false;
        nx--;
        ny++;
    }

    // 각 대각선을 체크했을 때 비숍이 없었다면 true를 리턴
    return true;
}

// 검은 칸 탐색 DFS
void blackDFS(int idx, int cnt) {
    // 검은 칸에 둘 수 있는 비숍의 최대값
    blackAns = max(blackAns, cnt);

    for (int i = idx; i < v.size(); i++) {
        int x = v[i].first;
        int y = v[i].second;
        // 짝수행에 홀수열은 흰 칸이므로
        if (x % 2 == 0 && y % 2 == 1) continue;
        // 홀수행에 짝수열은 흰 칸이므로
        if (x % 2 == 1 && y % 2 == 0) continue;
        if (!visit[x][y] && isPossible(x, y)) {
            visit[x][y] = true;
            blackDFS(i + 1, cnt + 1);
            visit[x][y] = false;
        }
    }
}

// 흰 칸 탐색 DFS
void whiteDFS(int idx, int cnt) {
    // 흰 칸에 둘 수 있는 비숍의 최대값
    whiteAns = max(whiteAns, cnt);

    for (int i = idx; i < v.size(); i++) {
        int x = v[i].first;
        int y = v[i].second;
        // 짝수행에 짝수열은 검은 칸이므로
        if (x % 2 == 0 && y % 2 == 0) continue;
        // 홀수행에 홀수열은 검은 칸이므로
        if (x % 2 == 1 && y % 2 == 1) continue;
        if (!visit[x][y] && isPossible(x, y)) {
            visit[x][y] = true;
            whiteDFS(i + 1, cnt + 1);
            visit[x][y] = false;
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
            if (map[i][j] == 1) v.push_back({ i, j });
        }
    }

    blackDFS(0, 0);
    whiteDFS(0, 0);

    cout << blackAns + whiteAns;
}