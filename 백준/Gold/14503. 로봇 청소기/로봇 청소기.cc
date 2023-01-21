#include <bits/stdc++.h>

using namespace std;

int n, m;
int r, c, d;

int Map[50][50] = { 0, };
int visited[50][50] = { 0, };

// 북 동 남 서
int dx[] = { 0, 1, 0, -1 };
int dy[] = { -1, 0, 1, 0 };

void dfs(int y, int x, int d, int sum)
{
	for (int i = 0; i < 4; i++)
	{
		int nd = (d + 3 - i) % 4;
		int ny = y + dy[nd];
		int nx = x + dx[nd];

		// 청소할 공간이 없다면
		if (ny < 0 || ny >= n || nx < 0 || nx >= m || Map[ny][nx] == 1)
		{
			continue;
		}

		// 청소할 공간이 있다면
		if (!visited[ny][nx] && !Map[ny][nx])
		{
			visited[ny][nx] = 1;
			dfs(ny, nx, nd, sum + 1);
		}
	}

	// 4방향을 다 돌았는데 전부 청소가 되어있거나 벽인경우는
	// 뒤가 벽일 경우와 아닌 경우로 나뉜다.
	// 뒤가 벽일 경우 작동을 정지한다.
	// 뒤가 벽이 아닐경우 뒤로 이동한다.
	// reverse direction

	int rd = (d + 2) % 4;
	int ry = y + dy[rd];
	int rx = x + dx[rd];

	// 뒤로 갔을 때 위치가 Map 안이고 벽이 아닌 공간이라면
	if (ry >= 0 && ry < n && rx >= 0 && rx < m && !Map[ry][rx])
	{
		dfs(ry, rx, d, sum);
	}
	else // 뒤로 가면 Map 밖이거나 벽일경우
	{
		cout << sum << endl;
		exit(0);
	}
}


int main()
{
	cin >> n >> m;
	cin >> r >> c >> d;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> Map[i][j];
		}
	}

	visited[r][c] = 1;
	dfs(r, c, d, 1);


	return 0;
}