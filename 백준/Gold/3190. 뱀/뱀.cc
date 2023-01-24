#include <bits/stdc++.h>

using namespace std;
// 판 크기
int n;
// 사과 개수
int k;
// 뱀의 방향 변환 횟수 -> X초 후에 'L' 왼쪽, 'D' 오른쪽 으로 머리를 90도 돌림
int l;
int cnt = 0;
int Map[100][100] = { 0, };
int dir = 0;
int idx = 0;

vector<pair<int, char>> turn;
deque<pair<int, int>> snake;

// 동 남 서 북
int dx[] = { 0, 1, 0, -1 };
int dy[] = { 1, 0 ,-1 ,0 };

void solve()
{
	int x = 0;
	int y = 0;
	while (1)
	{
		cnt++;

		int nx = snake.front().first + dx[dir];
		int ny = snake.front().second + dy[dir];

		// 뱀이 Map을 벗어나거나, 머리가 몸통에 닿을 경우
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || Map[nx][ny] == 2)
			break;
		// 뱀의 머리가 갈 곳이 빈칸이면 그쪽으로 옮김
		else if (Map[nx][ny] == 0)
		{
			Map[nx][ny] = 2;
			Map[snake.back().first][snake.back().second] = 0;
			snake.push_front(make_pair(nx, ny));
			snake.pop_back();
		}
		// 뱀의 머리가 사과를 먹었을 경우 사과자리에 뱀머리 추가.
		else if (Map[nx][ny] == 1)
		{
			Map[nx][ny] = 2;
			snake.push_front(make_pair(nx, ny));
		}

		if (idx < l && turn[idx].first == cnt)
		{
			char dir_char = turn[idx].second;

			if (dir_char == 'L')
			{
				dir = (dir + 3) % 4;
			}
			else if (dir_char == 'D')
			{
				dir = (dir + 1) % 4;
			}
			idx++;
		}
	}
}

int main()
{
	cin >> n >> k;

	// 사과 자리는 Map에서 1
	for (int i = 0; i < k; i++)
	{
		int x, y;
		cin >> x >> y;
		Map[x-1][y-1] = 1;
	}

	cin >> l;
	// 머리를 돌리는 좌표를 pair로 저장
	for (int i = 0; i < l; i++)
	{
		int x;
		char c;
		cin >> x >> c;
		turn.push_back(make_pair(x, c));
	}

	snake.push_back(make_pair(0, 0));
	// 뱀이 있음을 표시
	Map[0][0] = 2;
	solve();
	cout << cnt;
	return 0;
}