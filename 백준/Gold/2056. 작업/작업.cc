#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int n; // <= 100
int t[10002] = { 0, }; // 각 인덱스에 해당하는 작업들의 소요 시간.
int ind[10002] = { 0, }; // 선행 작업의 개수
int dp[10002] = { 0, }; // 동시에 진행했을 때 가장 오래 걸리는 작업을 선별하는 배열


vector<int> g[10002]; // 각 인덱스에 해당하는 작업의 선행 작업들이 각각 들어감.

int result = 0;

queue<int> q;

void dfs()
{
	for (int i = 1; i <= n; i++)
	{
		if (ind[i] == 0)
		{
			q.push(i); // 선행 작업이 없는 노드들을 q에 넣는다.
			dp[i] = t[i];
		}
	}

	for (int i = 1; i <= n; i++)
	{
		while (!q.empty())
		{
			int cur = q.front();
			result = max(result, dp[cur]);
			q.pop();

			for (int j = 0; j < g[cur].size(); j++) // 다음 할일들이 적혀있는 배열 크기만큼
			{
				int next = g[cur][j];
				dp[next] = max(dp[next], dp[cur] + t[next]);
				// 다음 할일이 적혀있는 시간 그래프에는 해당 일이 걸리는 시간과, 
				if (--ind[next] == 0)
				{
					q.push(next);
				}

			}
		}

	}
}


int main()
{
	cin >> n;

	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 1; i <= n; i++)
	{
		int inde;
		cin >> t[i];
		cin >> ind[i];

		for (int j = 0; j < ind[i]; j++)
		{
			int temp;
			cin >> temp;
			g[temp].push_back(i); 
			// g[temp] 에는 다음 할 작업으로 i가 들어감;
			// g[temp] 보다 i가 더 큰값임
			//  (1 +4)번째 줄의 6 1 1 의 경우 4번 노드는 6시간이 걸리고 1개의 선행 작업이 있는데 그것이 1이다. i = 4, ind[i] = 1, temp = 1 임
			// g[1] 벡터에 4를 넣는다.   4 <- 1
		}
	}

	dfs();

	cout << result;

	return 0;
}