#include <bits/stdc++.h>

using namespace std;

int n, m;
//int visited[8];
vector<int> v;

void bt(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < v.size(); i++)
		{
			cout << v[i] + 1 << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 0; i < n; i++)
	{
		v.push_back(i);
		bt(cnt + 1);
		v.pop_back();
	}
}

int main()
{
	cin >> n >> m;
	bt(0);

	return 0;
}