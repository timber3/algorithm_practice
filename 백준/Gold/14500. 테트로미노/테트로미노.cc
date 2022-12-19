#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

int n, m;

int g[501][501];
int visited[501][501] = { 0, };
// ㄷㅅㄴㅂ
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

int MAX = 0;

void dfs(int cnt, int total, int x, int y)
{
	if (cnt == 4)
	{
		if (MAX < total)
			MAX = total;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		if (x + dx[i] >= 0 &&
			x + dx[i] < n &&
			y + dy[i] >= 0 &&
			y + dy[i] < m &&
			!visited[x + dx[i]][y + dy[i]])
		{
			visited[x + dx[i]][y + dy[i]] = 1;
			dfs(cnt + 1, total + g[x + dx[i]][y + dy[i]], x + dx[i], y + dy[i]);
			visited[x + dx[i]][y + dy[i]] = 0;
		}
	}

	if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < n) { //ㅓ
		MAX = max(MAX, (g[x - 1][y] + g[x][y - 1] + g[x][y] + g[x + 1][y]));
	}
	if (x - 1 >= 0 && y + 1 < m && x + 1 < n) { //ㅏ
		MAX = max(MAX, (g[x - 1][y] + g[x][y + 1] + g[x][y] + g[x + 1][y]));
	}
	if (y - 1 >= 0 && y + 1 < m && x + 1 < n) { //ㅗ
		MAX = max(MAX, (g[x][y] + g[x + 1][y] + g[x + 1][y - 1] + g[x + 1][y + 1]));
	}
	if (y - 1 >= 0 && y + 1 < m && x + 1 < n) { //ㅜ
		MAX = max(MAX, (g[x][y - 1] + g[x][y] + g[x][y + 1] + g[x + 1][y]));
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> g[i][j];
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			//memset(visited, 0, sizeof(visited));
			visited[i][j] = 1;
			dfs(1,g[i][j],i,j);
			visited[i][j] = 0;

		}
	}

	cout << MAX;

	return 0;
}