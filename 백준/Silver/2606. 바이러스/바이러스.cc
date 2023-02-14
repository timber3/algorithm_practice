#include <bits/stdc++.h>

using namespace std;

int n, m;
int cnt;
vector<int> v[101];
queue<int> q;
int visited[101] = { 0, };

void bfs()
{
	while (!q.empty())
	{
		cnt++;
		int idx = q.front();

		q.pop();

		if (v[idx].size() > 0)
		{
			for (int i = 0; i < v[idx].size(); i++)
			{
				if (!visited[v[idx][i]])
				{
					visited[v[idx][i]] = 1;
					q.push(v[idx][i]);
				}
			}

		}
	}
}

int main()
{
	cin >> n >> m;


	for (int i = 0; i < m; i++)
	{
		int from, to;

		cin >> from >> to;

		v[from].push_back(to);
		v[to].push_back(from);
	}
	visited[1] = 1;
	q.push(1);

	bfs();

	cout << cnt - 1;

	return 0;
}