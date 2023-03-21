#include <bits/stdc++.h>

using namespace std;

int n, m;
int arr[8];

void bt(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < m; i++)
		{
			cout << arr[i] + 1 << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 0; i < n; i++)
	{
		arr[cnt] = i;
		bt(cnt + 1);
		arr[cnt] = 0;
	}
}

int main()
{
	cin >> n >> m;
	bt(0);

	return 0;
}