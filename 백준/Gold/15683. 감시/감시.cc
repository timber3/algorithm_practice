#include <bits/stdc++.h>

using namespace std;

int n, m;
// CCTV
int k;

int Map[8][8] = { 0, };

// 동 남 서 북
int dx[] = { 0, 1, 0, -1 };
int dy[] = { 1, 0,-1, 0 };

int Min = 999;

vector<pair<int, int>> v;

// 감시 1번, 2번, 3번, 4번, 5번
// 0 : 빈칸
// 1 : 한방향
// 2 : 반대
// 3 : 직각
// 4 : 4방향
// 5 : 4방향
// 6 : 벽
// 7 : CCTV 시야 범위


// x, y 에서의 CCTV 역할을 수행해준다.
void cctv(int x, int y, int dir)
{
	while (1)
	{
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			break;
		if (Map[nx][ny] == 6)
			break;
		// CCTV의 시야 범위를 7로 대체
		if (Map[nx][ny] >= 1 && Map[nx][ny] <= 5)
		{
			x += dx[dir];
			y += dy[dir];
			continue;
		}
		Map[nx][ny] = 7;

		x += dx[dir];
		y += dy[dir];
	}
}


void dfs(int cnt)
{
	if (cnt == v.size())
	{
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (Map[i][j] == 0)
					count++;
			}
		}
		Min = min(Min, count);
		return;
	}

	int x = v[cnt].first;
	int y = v[cnt].second;

	int roll_back[8][8] = { 0, };

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			roll_back[i][j] = Map[i][j];
		}
	}

	for (int i = 0; i < 4; i++)
	{
		if (Map[x][y] == 1)
		{
			cctv(x, y, i);
		}
		else if (Map[x][y] == 2)
		{
			cctv(x, y, i);
			cctv(x, y, (i + 2) % 4);
		}
		else if (Map[x][y] == 3)
		{
			cctv(x, y, i);
			cctv(x, y, (i + 1) % 4);
		}
		else if (Map[x][y] == 4)
		{
			cctv(x, y, i);
			cctv(x, y, (i + 1) % 4);
			cctv(x, y, (i + 2) % 4);
		}
		else if (Map[x][y] == 5)
		{
			cctv(x, y, i);
			cctv(x, y, (i + 1) % 4);
			cctv(x, y, (i + 2) % 4);
			cctv(x, y, (i + 3) % 4);
		}

		dfs(cnt + 1);

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				Map[i][j] = roll_back[i][j];
			}
		}
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> Map[i][j];
			if (Map[i][j] != 6 && Map[i][j] != 0)
			{
				// CCTV 면 좌표 저장
				v.push_back(make_pair(i, j));
			}
		}
	}

	dfs(0);
	cout << Min;

	return 0;
}