#include <bits/stdc++.h>

using namespace std;

int n, k;
int visited[100001];

queue<int> q;

int move(int idx, int cur)
{
	if (idx == 0)
		return cur + 1;
	if (idx == 1)
		return cur - 1;
	if (idx == 2)
		return cur * 2;
}

void bfs()
{
	while (!q.empty())
	{
		int cur = q.front();

		q.pop();

		if (cur == k)
			return;

		for (int i = 0; i < 3; i++)
		{
			int nx = move(i, cur);

			if (nx < 0 || nx >= 100001 || visited[nx] > -1)
				continue;

			else
			{
				visited[nx] = visited[cur] + 1;
				q.push(nx);
			}
		}
	}
}

int main()
{
	cin >> n >> k;

	fill(visited, visited + 100001, -1);
	q.push(n);
	visited[n] = 0;

	bfs();

	cout << visited[k];

	return 0;
}