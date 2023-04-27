#include <bits/stdc++.h>

using namespace std;

int n;

int Map[101][101];
int dis[101][101];
int visited[101][101];

int dx[] = {0,0,-1,1};
int dy[] = {1,-1,0,0};

typedef struct node {
	int x;
	int y;
};

void bfs()
{
	queue<node> q;

	for (int i = 0; i < n; i++)
	{
		fill(dis[i], dis[i] + n, -1);
	}

	q.push({ 0,0 });
	dis[0][0] = 0;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
			{
				continue;
			}
			
			if (dis[nx][ny] == -1 || Map[nx][ny] + dis[cx][cy] < dis[nx][ny])
			{
				q.push({ nx, ny });
				dis[nx][ny] = dis[cx][cy] + Map[nx][ny];
			}
		}
	}
}

int main()
{
	int t;
	cin >> t;

	for (int T = 0; T < t; T++)
	{
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			string str;
			cin >> str;

			for (int j = 0; j < n; j++)
			{
				Map[i][j] = str[j] - '0';
			}
		}

		bfs();

		cout << "#" << T+1 << " " << dis[n - 1][n - 1] << '\n';

	}

	return 0;
}