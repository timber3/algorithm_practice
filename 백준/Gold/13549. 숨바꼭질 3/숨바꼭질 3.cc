#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n, k;
int cnt;

int dist[100001];

struct node
{
	int cur;
	int cnt;
};

void bfs()
{
	deque<node> q;
	q.push_back({ n,0 });

	fill(dist, dist + sizeof(dist) / sizeof(int), 999999);
	dist[n] = 0;


	while (!q.empty())
	{
		int cur = q.front().cur;
		int cnt = q.front().cnt;

		q.pop_front();

		if (cur == k)
		{
			cout << dist[k];
			return;
		}

		// 순간이동
		if (cur * 2 <= 100001 && dist[cur * 2] > dist[cur])
		{
			dist[cur * 2] = dist[cur];
			q.push_front({ cur * 2, cnt });
		}

		// 앞으로 걷기
		if (cur + 1 <= 100001 && dist[cur + 1] > dist[cur] + 1)
		{
			dist[cur + 1 ] = dist[cur] + 1;
			q.push_back({ cur + 1, cnt+1 });
		}

		// 뒤로 걷기
		if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1)
		{
			dist[cur - 1] = dist[cur] + 1;
			q.push_back({ cur-1 , cnt+1 });
		}
	}
}

int main()
{
	cin >> n >> k;

	bfs();

	return 0;
}