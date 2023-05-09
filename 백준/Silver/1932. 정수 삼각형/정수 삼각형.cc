#include <bits/stdc++.h>

using namespace std;

int n;
int Map[501][501];
int dp[501][501];

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			cin >> Map[i][j];
		}
	}
	// 초기값 설정

	dp[1][1] = Map[1][1];

	for (int i = 2; i <= n; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + Map[i][j];
		}
	}

	int Max = 0;

	for (int i = 1; i <= n; i++)
	{
		if (Max < dp[n][i])
			Max = dp[n][i];
	}

	cout << Max;

	return 0;
}