#include <bits/stdc++.h>

using namespace std;

int n;

int r1, r2, c1, c2;

int Min = -1;

int dx[] = { -2, -2, 0, 0, 2, 2 };
int dy[] = { -1, 1, -2, 2, -1 ,1 };

int visited[201][201] = { 0, };

queue<pair<pair<int, int>,int>> q;

// r1 c1 에서 r2 c2로 최소 이동 횟수
// 못할 경우 -1

void bfs()
{
	for (int i = 0; i < 6; i++)
	{
		int nx = r1 + dx[i];
		int ny = c1 + dy[i];

		if (nx < 0 || ny < 0 || nx >= n || ny >= n)
			continue;

		q.push({{nx, ny},1 });
		visited[nx][ny] = 1;
	}

	while (!q.empty())
	{
		int x = q.front().first.first;
		int y = q.front().first.second;
		int cnt = q.front().second;

		q.pop();

		if (x == r2 && y == c2)
		{
			Min = cnt;
			break;
		}

		for (int i = 0; i < 6; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny])
				continue;

			q.push({ {nx,ny}, cnt +1 });
			visited[nx][ny] = 1;
		}

	}

}

int main()
{
	cin >> n;

	cin >> r1 >> c1 >> r2 >> c2;

	bfs();

	cout << Min;

	return 0;
}