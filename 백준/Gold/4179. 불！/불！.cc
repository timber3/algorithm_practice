#include <bits/stdc++.h>

using namespace std;

char Map[1001][1001];
int dist[1001][1001];
int fdist[1001][1001];

int r, c;

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

typedef struct node {
	int x;
	int y;
};

queue<node> fq;
queue<node> q;

int bfs()
{
	while (!fq.empty())
	{
		int cx = fq.front().x;
		int cy = fq.front().y;

		fq.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c || Map[nx][ny] == '#' || fdist[nx][ny] > -1)
				continue;
			else
			{
				fq.push({ nx, ny });
				fdist[nx][ny] = fdist[cx][cy] + 1;
			}

		}
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

			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				return dist[cx][cy] + 1;

			if (Map[nx][ny] == '#' || dist[nx][ny] > -1)
				continue;
			if (fdist[nx][ny] > -1 && fdist[nx][ny] <= dist[cx][cy] + 1)
				continue;
			
			dist[nx][ny] = dist[cx][cy] + 1;

			q.push({ nx,ny });
		}
	}

	return -1;
}

int main()
{
	cin >> r >> c;

	for (int i = 0; i < r; i++)
	{
		string str;
		cin >> str;

		fill(dist[i], dist[i] + c, -1);
		fill(fdist[i], fdist[i] + c, -1);

		for (int j = 0; j < str.size(); j++)
		{
			Map[i][j] = str[j];
			if (Map[i][j] == 'J')
			{
				q.push({ i,j });
				dist[i][j] = 0;
			}
			if (Map[i][j] == 'F')
			{
				fq.push({ i,j });
				fdist[i][j] = 0;
			}
		}
	}

	int result = bfs();

	if (result == -1)
		cout << "IMPOSSIBLE";
	else
		cout << result;

	return 0;
}