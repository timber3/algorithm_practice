#include <bits/stdc++.h>
#define Max 1000001

using namespace std;


int f, s, g, u, d;
int Min = -1;
int visited[Max] = { 0, };
// f층으로 된 건물에 G층에 스타트링크가 있다.
// 현재 S층에 있으며 U버튼 은 위로 U칸 D버튼은 아래로 D칸 움직인다.
// G층에 도착하려면 버튼을 최소 몇번 눌러야 하는가?
// 못가면 "use the stairs"를 출력한다.

int bfs()
{
	// q에는 현재 층, 움직인 횟수가 들어간다.
	queue<pair<int, int>> q;

	q.push({ s,0 });

	while (!q.empty())
	{
		int cur = q.front().first;
		int cnt = q.front().second;

		q.pop();

		if (cur == g)
		{
			return cnt;
		}

		if (visited[cur])
			continue;

		visited[cur] = 1;

		int up = cur + u;
		int down = cur - d;

		if ( up <= f && !visited[up])
		{
			q.push({ up, cnt + 1 });
		}
		if (down > 0 && !visited[down])
		{
			q.push({ down, cnt + 1 });
		}
	}

	return -1;
}

int main()
{
	cin >> f >> s >> g >> u >> d;

	Min = bfs();

	if (Min == -1)
	{
		cout << "use the stairs";
	}
	else
	{
		cout << Min;
	}

	return 0;

}