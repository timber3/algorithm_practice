#include <iostream>
#include <queue>

#define endl "\n"

using namespace std;

int s;
int result = 1;
int temp = 0;
int visited[1001][1001] = { 0, };

struct node
{
	int cur;
	int cnt;
	int clip;
};

queue<node> q;


void bfs()
{
	q.push({ 1,0,0 });
	visited[1][0] = 1;

	while (!q.empty())
	{
		int cur = q.front().cur;
		int cnt = q.front().cnt;
		int clp = q.front().clip;

		q.pop();

		if (cur == s)
		{
			cout << cnt;
			return;
		}

		if (!visited[cur][cur])
		{
			visited[cur][cur] = 1;
			q.push({ cur, cnt + 1 , cur });
		}

		if (cur + clp <= s && !visited[cur + clp][clp])
		{
			visited[cur + clp][clp] = 1;
			q.push({ cur + clp, cnt + 1, clp });
		}

		if (cur - 1 >= 0 && !visited[cur - 1][clp])
		{
			visited[cur - 1][clp] = 1;
			q.push({ cur - 1, cnt + 1, clp });
		}
	}
}

int main()
{
	cin >> s;

	bfs();

	return 0;
}