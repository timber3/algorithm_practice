#include <bits/stdc++.h>

using namespace std;

int n, m;
int can_use[10001];
vector<int> v;

void bt(int cnt, int idx)
{
	if (cnt == m)
	{
		for (int i = 0; i < v.size(); i++)
		{
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = idx; i < 10001; i++)
	{
		if (can_use[i] != 0)
		{
			v.push_back(i);
			can_use[i] --;
			bt(cnt + 1, i);
			v.pop_back();
			can_use[i]++;
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
		can_use[temp] ++;
	}

	bt(0, 0);

	return 0;
}