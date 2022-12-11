#include <iostream>
#include <queue>

#define endl "\n"

using namespace std;

int n, k;
int cnt;
int visit[100001] = { 0, };

struct node
{
	int cur;
	int cnt;
};

int move(int cur, int dir)
{
	switch (dir)
	{
		case 0: // 앞으로 걷기
		{
			return cur + 1;
		}	
		case 1: // 뒤로 걷기
		{
			return cur - 1;
		}
		case 2: // 순간이동 하기
		{
			return cur * 2;
		}
	}
}

void bfs()
{
	queue<node> q;
	q.push({ n,0 });
	visit[n] = 1;

	while (!q.empty())
	{
		int cur = q.front().cur;
		int cnt = q.front().cnt;
		q.pop();

		if (cur == k)
		{
			cout << cnt;
			return;
		}

		for (int i = 0; i < 3; i++)
		{
			int next = move(cur,i);
			if (next <= 100000 && next >= 0 && !visit[next])
			{
				q.push({ next, cnt + 1 });
				visit[next] = 1;
			}
		}
	}
}

int main()
{
	cin >> n >> k;

	bfs();

	return 0;
}