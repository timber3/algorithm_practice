#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> v;

int visited[15] = { 0, };
int sum = 0;
int cur;
int n;

void dfs(int cnt, int cur)
{
	// cnt가 n 이 되면 중단 후 최대값 비교
	if (cnt == n)
	{
		sum = max(sum, cur);
		return;
	}

	// 하면 더하고
	if (visited[cnt] != 1 && v[cnt][0] <= n - cnt)
	{
		for (int i = cnt; i < cnt + v[cnt][0]; i++)
		{
			visited[i] = 1;
		}

		dfs(cnt + 1, cur + v[cnt][1]);

		for (int i = cnt; i < cnt + v[cnt][0]; i++)
		{
			visited[i] = 0;
		}
	}

	// 안하면 안더하고
	dfs(cnt + 1, cur);

}

int main()
{
	// 모든 경우를 해봐야 하기 때문에 dfs로 구성함.
	// visited 를 통해 일을 한 기간만큼 visited를 체크해서 방문하지 않도록 함.
	
	cin >> n;
	
	for (int i = 0; i < n; i++)
	{
		int temp;
		vector<int> t;
		cin >> temp;
		v.push_back(t);
		v[i].push_back(temp);
		cin >> temp;
		v[i].push_back(temp);
	}

	dfs(0, 0);

	cout << sum;

	return 0;
}