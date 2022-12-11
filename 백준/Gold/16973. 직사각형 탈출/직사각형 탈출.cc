#include <iostream>
#include <queue>

#define endl "\n"

using namespace std;

int n, m; // 격자판 크기

int h, w; // 직사각형 크기

int sr, sc, fr, fc; // 초기 좌표 , 목표 좌표

int g[1001][1001];
int visited[1001][1001] = { 0, };


// 동 서 남 북
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

struct node
{
	int x, y, count;
};

bool wallcheck(int i, int x, int y)
{
	switch (i)
	{
		case 0: // 오른쪽으로 이동
		{
			int ny = y + w -1;
			if (ny > m) return false;

			for (int i = x; i < x + h; i++)
			{
				if (g[i][ny] == 1) return false;
			}
			break;
		}
		case 1: // 왼쪽으로 이동
		{
			for (int i = x; i < x + h; i++)
			{
				if (g[i][y] == 1) return false;
			}
			break;
		}
		case 2: // 아래쪽으로 이동
		{
			int nx = x + h -1;
			if (nx > n) return false;

			for (int i = y; i < y + w; i++)
			{
				if (g[nx][i] == 1) return false;
			}
			break;
		}
		case 3: // 위쪽으로 이동
		{
			for (int i = y; i < y + w; i++)
			{
				if (g[x][i] == 1) return false;
			}
			break;
		}
	}
	return true;
}

void bfs()
{
	queue<node> q;

	q.push({ sr,sc, 0 });

	visited[sr][sc] = 1;

	while (!q.empty())
	{
		node cur = q.front();
		q.pop();

		int x = cur.x;
		int y = cur.y;
		int count = cur.count;

		if (x == fr && y == fc)
		{
			cout << count << endl;
			return;
		}

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];

			if (nx >= 1 && ny >= 1 && nx <= n && ny <= m)
			{
				if (!visited[nx][ny])
				{
					if (wallcheck(i, nx, ny))
					{
						q.push({ nx, ny, count + 1 });
						visited[nx][ny] = 1;
					}
				}
			}
		}
	}

	cout << -1 << endl;
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i < n+1; i++)
	{
		for (int j = 1; j < m+1; j++)
		{
			cin >> g[i][j];
		}
	}

	cin >> h >> w >> sr >> sc >> fr >> fc;

	bfs();

	return 0;
}