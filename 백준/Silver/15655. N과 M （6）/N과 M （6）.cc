#include <bits/stdc++.h>

using namespace std;

int n, m;
int visited[10001];
vector<int> v;
vector<int> result;

void bt(int cnt, int cur)
{
	if (cnt == m)
	{
		for (int i = 0; i < result.size(); i++)
		{
			cout << result[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = cur; i < n; i++)
	{
		if (!visited[v[i]])
		{
			visited[v[i]] = 1;
			result.push_back(v[i]);
			bt(cnt + 1, i + 1);
			visited[v[i]] = 0;
			result.pop_back();
		}
	}
	return;
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

	bt(0, 0);

	return 0;
}