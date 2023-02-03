#include <bits/stdc++.h>

using namespace std;

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

int n;
int Map[21][21] = { 0, };
int dist[21][21];
int sec = 0;
int shark_size = 2;
int sx = 0; // shark_x
int sy = 0; // shark_y
int eat_count = 0;

void init_dist()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			dist[i][j] = -1;
		}
	}
}

bool bfs()
{
	// 최단거리를 구해주기
	// 최단거리를 처음에 -1로 세팅해주기
	init_dist();
	dist[sx][sy] = 0;

	queue<pair<int, int>> q;

	q.push({ sx, sy });

	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		// 만약 다음 간 곳에 물고기가 상어보다 크다면
		if (Map[x][y] != 9 && Map[x][y] != 0 && Map[x][y] > shark_size)
		{
			continue;
		}
		else
		{
			// 최단 거리를 구해본다.
			for (int i = 0; i < 4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 크기가 같은 물고기는 지나갈 수는 있어야 한다.( 같으면 dist 표기 해야함 )
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || Map[nx][ny] > shark_size || dist[nx][ny] != -1)
				{
					continue;
				}
				else
				{
					dist[nx][ny] = dist[x][y] + 1;
					q.push({ nx, ny });
				}
			}
		}
	}

	// 여기까지 했으면 dist 에는 현재 상태에서 최단거리를 담아두었음.

	int Min = 99999;
	int fish_x = 0;
	int fish_y = 0;
	int flag = 0;

	// 뒤에서 부터 확인하여 갱신되면 왼쪽 위의 값이 갱신 되도록 설정
	for (int i = n - 1; i >= 0; i--)
	{
		for (int j = n - 1; j >= 0; j--)
		{
			// 크기가 같은 물고기를 먹으러 가는건 안됨.
			if (Min >= dist[i][j] && Map[i][j] != 9 && Map[i][j] != 0 && dist[i][j] != -1 && Map[i][j] != shark_size)
			{
				Min = dist[i][j];
				fish_x = i;
				fish_y = j;
				flag = 1;
			}
		}
	}

	if (flag == 0)
	{
		return false;
	}
	else
	{
		Map[fish_x][fish_y] = 9;
		Map[sx][sy] = 0;
		sx = fish_x;
		sy = fish_y;
		eat_count++;

		if (eat_count == shark_size)
		{
			shark_size++;
			eat_count = 0;
		}

		sec += dist[fish_x][fish_y];
		return true;
	}

}


int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> Map[i][j];
			if (Map[i][j] == 9)
			{
				sx = i;
				sy = j;
			}
		}
	}

	while (1)
	{
		if (bfs())
		{
			continue;
		}
		break;
	}

	cout << sec;

	return 0;
}