#include <bits/stdc++.h>

using namespace std;

int t, k, n, m;
int Max = 0;

int Map[51][51] = { 0, };
int visited[51][51] = { 0, };

int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1, 0, 0 };

int pic_cnt = 0;

typedef struct node
{
	int x;
	int y;
};

queue<node> q;

void bfs()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (Map[i][j] == 1 && !visited[i][j])
			{
				pic_cnt++;
				q.push(node{ i,j });
				visited[i][j] = 1;

				int cnt = 0;

				while (!q.empty())
				{
					int cx = q.front().x;
					int cy = q.front().y;
					cnt++;
					q.pop();

					for (int k = 0; k < 4; k++)
					{
						int nx = cx + dx[k];
						int ny = cy + dy[k];

						if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
							continue;

						if (Map[nx][ny] == 1)
						{
							q.push(node{ nx,ny });
							visited[nx][ny] = 1;
						}
					}
				}
				if (Max < cnt)
					Max = cnt;
			}
		}
	}
	cout << pic_cnt <<"\n";
}

int main()
{
	cin >> t;

	for (int T = 0 ; T < t ; T ++)
	{
		pic_cnt = 0;
		cin >> m >> n >> k;

		for(int j = 0 ; j < k ; j ++)
		{
			int x, y;
			cin >> x >> y;
			Map[y][x] = 1;
		}

		bfs();

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				visited[i][j] = 0;
				Map[i][j] = 0;
			}
		}
	}

	return 0;
}