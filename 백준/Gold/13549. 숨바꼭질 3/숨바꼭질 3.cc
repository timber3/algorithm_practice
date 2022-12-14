#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

/// <summary>
/// 
///		BFS 로 푸는 문제이나
///		다음 노드로 이동할 때 간선의 가중치가 존재한다.
/// 
///		순간이동은 가중치가 0 걷기는 가중치가 1
/// 
///		BFS는 가중치가 존재하는 순간 최단거리를 구할 수 없게 되기 때문에
///		0-1 BFS 를 사용하거나 다익스트라를 통한 문제 풀이를 해야한다.
/// 
///		여기서는 deqeue 를 사용한 0-1 BFS를 사용하였다.
/// </summary>
/// 
int n;
int k;

int result[100001] = { 0, };

// visited[] 는 체크를 하기 위함 ( BFS 에서만 )
// visited[] 대신 distance를 사용함
int dist[100001];

vector<int> par(100001);

struct node {
	int cur;
};

void bfs()
{
	deque<node> dq;
	dq.push_back({ n });

	fill(dist, dist + sizeof(dist)/4, 999999);

	// 현재 거리 초기화
	dist[n] = 0;

	while (!dq.empty())
	{
		int cur = dq.front().cur;

		dq.pop_front();

		if (cur == k)
		{
			cout << dist[k];
			return;
		}

		// 순간이동
		if (cur * 2 < 100001 && dist[cur*2] > dist[cur])
		{
			dq.push_front({ cur * 2 });
			dist[cur * 2] = dist[cur];
		}

		// 앞으로 걷기
		if (cur + 1 <= 100001 && dist[cur + 1] > dist[cur] + 1)
		{
			dq.push_back({ cur + 1});
			dist[cur + 1] = dist[cur] + 1;
		}

		// 뒤로 걷기
		if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1)
		{
			dq.push_back({ cur - 1 });
			dist[cur - 1] = dist[cur] + 1;
		}

	}
}

int main()
{
	cin >> n >> k;

	bfs();

	return 0;
}