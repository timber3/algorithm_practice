#include <bits/stdc++.h>

using namespace std;

int n;
int Map[501][501];
int dp[501][501];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			cin >> Map[i][j];
		}
	}
	// 초기값 설정

	dp[0][0] = Map[0][0];

	for (int i = 1; i < n; i++)
	{
		dp[i][i] = dp[i - 1][i - 1] + Map[i][i];
	}

	for (int i = 1; i < n; i++)
	{
		dp[i][0] = dp[i - 1][0] + Map[i][0];
	}

	for (int i = 2; i < n; i++)
	{
		for (int j = 1; j < i; j++)
		{
			dp[i][j] = max(dp[i - 1][j-1], dp[i-1][j]) + Map[i][j];
		}
	}

	int Max = 0;

	for (int i = 0; i < n; i++)
	{
		if (Max < dp[n - 1][i])
			Max = dp[n - 1][i];
	}

	cout << Max;

	return 0;
}