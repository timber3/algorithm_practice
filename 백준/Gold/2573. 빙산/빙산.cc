// 9:12
#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[301][301];
int visited[301][301];
int cvisited[301][301];

int year = 0;

int dx[] = { 0, 0, -1 ,1 };
int dy[] = { 1, -1, 0 ,0 };

typedef struct node {
	int x;
	int y;
};

void bfs(int x, int y)
{
	queue<node> q;
	q.push({ x, y });
	visited[x][y] = 1;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 1)
				continue;

			if (Map[nx][ny] == 0)
			{
				Map[cx][cy] -= 1;
			}

			if (Map[nx][ny] > 0)
			{
				q.push({ nx,ny });
				visited[nx][ny] = 1;
			}

			if (Map[cx][cy] < 0)
				Map[cx][cy] = 0;
		}
	}
}

void cbfs(int x, int y)
{
	queue<node> q;
	q.push({ x, y });
	cvisited[x][y] = 1;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || cvisited[nx][ny] == 1)
				continue;

			if (Map[nx][ny] > 0)
			{
				q.push({ nx, ny });
				cvisited[nx][ny] = 1;
			}
		}
	}
}

int solve()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (Map[i][j] > 0 && visited[i][j] == 0)
			{
				bfs(i, j);
				year++;
			}
		}
	}
	
	int cnt = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (Map[i][j] > 0 && cvisited[i][j] == 0)
			{
				cbfs(i,j);
				cnt++;
			}

			if (cnt >= 2)
			{
				cout << year << '\n';
				return 1;
			}
		}
	}

	if (cnt == 0)
	{
		cout << 0 << '\n';
		return 1;
	}

	for (int i = 0; i < n; i++)
	{
		fill(visited[i], visited[i] + m, 0);
		fill(cvisited[i], cvisited[i] + m, 0);
	}

	return 0;
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> Map[i][j];
		}
	}

	while (1)
	{
		int result = solve();
		if (result == 1)
			break;
	}

	return 0;
}