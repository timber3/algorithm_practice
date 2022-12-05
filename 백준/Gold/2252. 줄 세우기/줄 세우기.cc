#include <iostream>
#include <vector>
#include <queue>

#define MAX 32001
using namespace std;

int n;
int m;

int a;
int b;

int inDegree[MAX];
vector<int> v[MAX];
queue<int> q;

vector<int> result;

void bfs()
{
	for (int i = 1; i <= n; i++)
		if (!inDegree[i]) // 0인 노드를 q에 넣는다.
			q.push(i);

	while (!q.empty())
	{
		int cur = q.front();
		result.push_back(q.front());
		q.pop();

		for (int i = 0; i < v[cur].size(); i++)
		{
			inDegree[v[cur][i]] --;
			if (!inDegree[v[cur][i]])
				q.push(v[cur][i]);
		}

	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> a >> b;

		v[a].push_back(b);
		inDegree[b]++;
	}

	bfs();

	for (int i = 0; i < n; i++)
	{
		cout << result[i] << " ";
	}

	return 0;
}