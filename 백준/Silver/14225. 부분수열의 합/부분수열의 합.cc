#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n;

int arr[21];
int visited[2000001];

void dfs(int cnt, int total)
{
	if (cnt == n)
	{
		if (!visited[total])
		{
			visited[total] = 1;
		}
		return;
	}

	dfs(cnt + 1, total);

	dfs(cnt + 1, total + arr[cnt]);
}


int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	dfs(0,0);

	for (int i = 1; i <= 2000001; i++)
	{
		if (!visited[i])
		{
			cout << i;
			break;
		}
	}


	return 0;
}