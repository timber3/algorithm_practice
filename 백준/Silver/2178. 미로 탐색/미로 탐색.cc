#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[101][101];
int visited[101][101];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

typedef struct node {
	int x;
	int y;
	int cnt;
};

int bfs()
{
	queue<node> q;
	q.push({ 1,1,1 });
	visited[1][1] = 1;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int cnt = q.front().cnt;

		if (cx == n && cy == m)
		{
			return cnt;
		}

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx <= 0 || ny <= 0 || nx > n || ny > m || visited[nx][ny])
				continue;

			if (Map[nx][ny] == 1)
			{
				q.push({ nx,ny,cnt+1 });
				visited[nx][ny] = 1;
			}
		}

	}
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		string str;

		cin >> str;

		for (int j = 0; j < str.size(); j++)
		{
			Map[i][j+1] = str[j] - '0';
		}
	}

	int result = bfs();

	cout << result;
}