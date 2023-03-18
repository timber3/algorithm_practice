#include <bits/stdc++.h>

using namespace std;

int n;
int Map[101][101];
int visited[101][101];
int Max = 0;
int result = 0;
int cnt = 0;
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

typedef struct node {
	int x;
	int y;
};

queue<node> q;

void bfs(int x, int y)
{
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

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == 1 || visited[nx][ny] == -1)
				continue;

			else
			{
				q.push({ nx, ny });
				visited[nx][ny] = 1;
			}
		}
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
			if (Max < Map[i][j])
				Max = Map[i][j];
		}
	}

	for (int i = 0; i < Max; i++)
	{
		// val 이하의 영역은 visited 를 -1로 지정해주기
		for (int j = 0; j < n; j++)
		{
			fill(visited[j], visited[j] + n, 0);

			for (int k = 0; k < n; k++)
			{
				if (Map[j][k] <= i)
					visited[j][k] = -1;
			}
		}

		// visited -1로 지정해줬으면 이제 -1이 아닌 부분을 골라서 bfs돌리기
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				// 방문 처리도 visited로 하기 때문에 방문한 곳은 1, 방문할 필요가 없는곳은 -1 이므로 0인 부분만 방문한다.
				if (visited[j][k] == 0)
				{
					cnt++;
					bfs(j, k);
				}
			}
		}

		// 다 돌았으면 구역의 개수를 비교 후 결과에 반영
		result = max(result, cnt);

		cnt = 0;
	}

	cout << result;

	return 0;
}