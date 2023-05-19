#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[11][11];
int visited[11];
int Max;

void dfs(int cnt, int st)
{
	if (cnt > Max)
	{
		Max = cnt;
	}

	for (int i = 1; i <= n; i++)
	{
		if (Map[st][i] == 1 && !visited[i])
		{
			visited[i] = 1;
			dfs(cnt + 1, i);
			visited[i] = 0;
		}
	}

	return;
}

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		Max = 0;

		for (int i = 0; i < 11; i++)
		{
			fill(Map[i], Map[i] + 11, 0);
		}

		fill(visited, visited + 11, 0);

		cin >> n >> m;

		for (int i = 0; i < m; i++)
		{
			int st, des;
			cin >> st >> des;

			Map[st][des] = 1;
			Map[des][st] = 1;
		}

		for (int i = 1; i <= n; i++)
		{
			visited[i] = 1;
			dfs(1, i);
			visited[i] = 0;
		}

		cout << "#" << t + 1 << " " << Max << '\n';

	}

	return 0;
}