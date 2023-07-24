#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[8][8];
int copy_Map[8][8];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
int Max = 0;

typedef struct virus {
	int x;
	int y;
};

vector<virus> v;

void copyMap() {
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			copy_Map[i][j] = Map[i][j];
		}
	}
}

void returnMap() {
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			Map[i][j] = copy_Map[i][j];
		}
	}
}

void bfs()
{
	queue<virus> q;

	for (int i = 0; i < v.size(); i++)
	{
		q.push({ v[i].x, v[i].y });
	}

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || Map[nx][ny] != 0)
				continue;

			Map[nx][ny] = 2;
			q.push({ nx, ny });
		}
	}

	int safe = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (Map[i][j] == 0)
			{
				safe++;
			}
		}
	}

	Max = max(safe, Max);
}

void make_wall(int cnt)
{
	if (cnt == 3)
	{
		copyMap();
		bfs();
		returnMap();

		return;
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (Map[i][j] == 0)
			{
				Map[i][j] = 1;
				make_wall(cnt + 1);
				Map[i][j] = 0;
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

			if (Map[i][j] == 2)
			{
				v.push_back({ i,j });
			}
		}
	}

	make_wall(0);

	cout << Max;

	return 0;
}