#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[1001][1001];
int visited[1001][1001];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
int Min = -1;

typedef struct node {
	int x;
	int y;
	int cnt;
};

queue<node> q;

void bfs()
{
	while (!q.empty())
	{
		int x = q.front().x;
		int y = q.front().y;
		int cnt = q.front().cnt;

		Map[x][y] = 1;

		if (Min < cnt)
			Min = cnt;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || Map[nx][ny] == -1)
				continue;

			if (!visited[nx][ny] && Map[nx][ny] == 0)
			{
				q.push({ nx,ny,cnt + 1 });
				visited[nx][ny] = 1;
			}

		}
	}

}

int main()
{
	cin >> m >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> Map[i][j];

			if (Map[i][j] == 1)
				q.push({ i,j,0 });
		}
	}

	bfs();

	int can_go = 1;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			if (Map[i][j] == 0)
			{
				can_go = 0;
				break;
			}
	}

	if (can_go == 1)
		cout << Min;
	else
		cout << -1;

	return 0;
}