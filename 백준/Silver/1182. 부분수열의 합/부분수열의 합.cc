#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n, s;

int arr[21];
int counter = 0;
int visited[21] = { 0, };

void dfs(int cnt, int total)
{
	if (cnt == n)
	{
		if ( total == s )
		{
			counter++;
		}
		return;
	}

	// 해당 숫자를 넣는 경우.
	dfs(cnt + 1, total + arr[cnt]);

	// 해당 숫자를 넣지 않는 경우.
	dfs(cnt + 1, total);
}

int main()
{
	cin >> n >> s;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	dfs(0, 0);

	if (s == 0)
		counter--;

	cout << counter;

	return 0;
}