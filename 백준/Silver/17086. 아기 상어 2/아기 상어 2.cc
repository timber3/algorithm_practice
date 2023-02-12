#include <bits/stdc++.h>

using namespace std;

int n, m;

int Map[51][51] = { 0, };
int dis[51][51] = { 0, };
int visited[51][51] = { 0, };

int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
int dy[] = { 1, -1 ,0 ,0, 1, -1, 1, -1 };

int Max = 0;
typedef struct node {
	int x;
	int y;
	int dis;
};

queue<node> q;

void bfs()
{
	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int cdis = q.front().dis;

		q.pop();

		for (int i = 0; i < 8; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || dis[nx][ny] == -1 || visited[nx][ny])
				continue;
			else
			{
				if (dis[nx][ny] != 0 && dis[nx][ny] < cdis + 1)
					continue;
				else
				{
					q.push({ nx, ny, cdis + 1 });
					dis[nx][ny] = cdis + 1;
					visited[nx][ny] = 1;
				}
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
			if(Map[i][j] == 1)
			{
				dis[i][j] = -1;
				q.push({ i, j, 0 });
			}
		}
	}

	bfs();

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (dis[i][j] > Max)
				Max = dis[i][j];
		}
	}

	cout << Max;

	return 0;
}