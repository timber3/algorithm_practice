#include <bits/stdc++.h>

using namespace std;

int Map[50][50];
int visited[50][50];
int result;
int n;

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

typedef struct node {
	int x;
	int y;
	int d;
};

void bfs()
{
	queue<node> q;

	int x = n / 2;
	int y = n / 2;

	q.push({ x,y,1 });
	visited[x][y] = 1;
	result += Map[x][y];

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int cd = q.front().d;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny])
				continue;

			else
			{
				if (cd == n / 2 )
				{
					visited[nx][ny] = 1;
					result += Map[nx][ny];
				}
				else
				{
					visited[nx][ny] = 1;
					result += Map[nx][ny];
					q.push({ nx,ny,cd + 1 });
				}
			}
		}
	}
}


int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> n;
		result = 0;

		for (int i = 0; i < 50; i++)
		{
			fill(Map[i], Map[i] + 50, 0);
			fill(visited[i], visited[i] + 50, 0);
		}

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

		cout << "#" << t + 1 << " " << result << '\n';
	}

	return 0;
}