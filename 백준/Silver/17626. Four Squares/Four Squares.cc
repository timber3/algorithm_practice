#include <bits/stdc++.h>

using namespace std;

int n;

int dp[50001] = { 0, };

int main()
{
	cin >> n;

	// n 보다 작은 수 중에서 가장 큰 제곱수를 뺀 값들중 dp값이 가장 작은 애를 선정

	dp[1] = 1;

	for (int i = 2; i <= n; i++)
	{
		int Min = 999999999;
		for (int j = 1; j * j <= i; j++)
		{
			int temp = i - (j * j);
			Min = min(Min, dp[temp]);
		}

		dp[i] = Min + 1;
	}

	cout << dp[n];

	return 0;
}

