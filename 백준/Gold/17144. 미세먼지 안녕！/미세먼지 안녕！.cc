#include <bits/stdc++.h>

using namespace std;

int r, c, t;
int sum = 0;
int Map[51][51];

int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1 ,0, 0 };

// 공기청정기 윗부분1 아랫부분2
int filter_x1;
int filter_y1;
int filter_x2;
int filter_y2;

void solve()
{
	while (t--)
	{
		vector<pair<int, pair<int, int>>> dust;

		// 먼지는 동시에 확산하기 때문에 벡터에 담아둔 후 여기서만 확산시키기
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (Map[i][j] != -1 && Map[i][j] != 0)
				{
					dust.push_back({ Map[i][j],{ i,j } });
				}
			}
		}

		// 1. 먼지의 확산
		for (int i = 0; i < dust.size(); i++)
		{
			int val = dust[i].first;
			int x = dust[i].second.first;
			int y = dust[i].second.second;
			int div_cnt = 0;

			for (int j = 0; j < 4; j++)
			{
				int nx = x + dx[j];
				int ny = y + dy[j];

				// nx,ny 가 범위를 벗어나거나 공기청정기면 확산이 안됨
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || Map[nx][ny] == -1)
					continue;

				Map[nx][ny] += val / 5;
				div_cnt++;
			}

			Map[x][y] -= (val / 5) * div_cnt;
		}

		// 2. 공기청정기 작동
		for (int i = filter_x1 - 1; i >= 0; i--)
		{
			if (Map[i + 1][0] == -1)
				Map[i][0] = 0;
			else
				Map[i + 1][0] = Map[i][0];
		}

		for (int i = filter_x2 + 1; i <= r-1; i++)
		{
			if (Map[i - 1][0] == -1)
				Map[i][0] = 0;
			else
				Map[i - 1][0] = Map[i][0];
		}

		for (int i = 1; i <= c-1; i++)
		{
			Map[0][i - 1] = Map[0][i];
			Map[r-1][i - 1] = Map[r-1][i];
		}

		for (int i = 1; i <= filter_x1; i++)
		{
			Map[i-1][c-1] = Map[i][c-1];
		}
		for (int i = r - 2; i >= filter_x2; i--)
		{
			Map[i+1][c-1] = Map[i][c-1];
		}

		for (int i = c-1; i > 1; i--)
		{
			Map[filter_x1][i] = Map[filter_x1][i - 1];
			Map[filter_x2][i] = Map[filter_x2][i - 1];
			Map[filter_x1][i - 1] = 0;
			Map[filter_x2][i - 1] = 0;
		}
	}
}

int main()
{
	cin >> r >> c >> t;

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			cin >> Map[i][j];

			if (Map[i][j] == -1)
			{
				filter_x2 = i;
				filter_y2 = j;
			}
		}
	}

	filter_x1 = filter_x2 - 1;
	filter_y1 = filter_y2;

	solve();

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			sum += Map[i][j];
		}
	}
	sum += 2;

	cout << sum;

	return 0;
}
