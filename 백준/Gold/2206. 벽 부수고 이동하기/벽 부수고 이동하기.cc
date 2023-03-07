#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[1001][1001];
int visited[1001][1001][2];

int Min = 999999999;

int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1, 0, 0 };

typedef struct node
{
	int x;
	int y;
	int cnt;
	int flag;
};

queue<node> q;

int bfs()
{
	visited[0][0][0] = 1;
	q.push(node{ 0,0,1,0 });

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int cnt = q.front().cnt;
		int flag = q.front().flag;

		q.pop();

		if (cx == n - 1 && cy == m - 1)
			return cnt;

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			if (Map[nx][ny] == 1 && flag == 0)
			{
				visited[nx][ny][1] = 1;
				q.push(node{ nx, ny, cnt + 1, 1 });
			}

			if (Map[nx][ny] == 0 && !visited[nx][ny][flag])
			{
				visited[nx][ny][flag] = 1;
				q.push(node{ nx, ny, cnt + 1, flag });
			}
		}
	}

	return -1;
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < m; j++)
		{
			Map[i][j] = str[j] - '0';
		}
	}

	int result = bfs();

	cout << result;

	return 0;
}