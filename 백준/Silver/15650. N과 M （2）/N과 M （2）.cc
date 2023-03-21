#include <bits/stdc++.h>

using namespace std;

int n, m;
int visited[8];
vector<int> v;

void bt(int start, int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < v.size(); i++)
		{
			cout << v[i] + 1 << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = start; i < n; i++)
	{
		if (visited[i] == 0)
		{
			visited[i] = 1;
			v.push_back(i);
			bt(i, cnt + 1);
			visited[i] = 0;
			v.pop_back();
		}
	}

}

int main()
{
	cin >> n >> m;

	bt(0,0);

	return 0;
}