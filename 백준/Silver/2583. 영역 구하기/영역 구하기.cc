#include <bits/stdc++.h>

using namespace std;

int m, n, k;

int Map[101][101];
int visited[101][101];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1, 0, 0 };

typedef struct node {
	int x;
	int y;
	int cnt;
};

queue<node> q;
vector<int> v;

int bfs(int i, int j)
{
	q.push(node{ i,j,1 });
	visited[i][j] = 1;
	
	int val = 0;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int cnt = q.front().cnt;

		q.pop();

		val++;

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny] || Map[nx][ny])
				continue;
			else
			{
				q.push(node{ nx,ny,cnt + 1 });
				visited[nx][ny] = 1;
			}
		}
	}

	return val;
}

int main()
{
	cin >> m >> n >> k;

	for (int i = 0; i < k; i++)
	{
		int x1, y1, x2, y2;
		cin >> y1 >> x1 >> y2 >> x2;

		for (int i = x1; i < x2; i++)
		{
			for (int j = y1; j < y2; j++)
			{
				Map[i][j] = 1;
			}
		}
	}

	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (Map[i][j] != 1 && !visited[i][j])
			{
				int result = bfs(i,j);
				v.push_back(result);
			}
		}
	}

	sort(v.begin(), v.end());

	cout << v.size() << "\n";

	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}

	return 0;
}