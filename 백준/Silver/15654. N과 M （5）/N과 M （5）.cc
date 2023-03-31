#include <bits/stdc++.h>

using namespace std;


int n, m;
int visited[10001];
vector<int> v;
vector<int> result;

void bt(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < m; i++)
		{
			cout << result[i] << " ";
		}
		cout << "\n";

		return;
	}

	for (int i = 0; i < n; i++)
	{
		if (!visited[i])
		{
			visited[i] = 1;
			result.push_back(v[i]);
			bt(cnt + 1);
			visited[i] = 0;
			result.pop_back();
		}
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	bt(0);

	return 0;
}