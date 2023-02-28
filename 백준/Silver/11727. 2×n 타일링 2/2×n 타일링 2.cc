#include <bits/stdc++.h>

using namespace std;

int n;
long long dp[1001];

int main()
{
	cin >> n;

	dp[1] = 1;
	dp[2] = 3;
	dp[3] = 5;

	for (int i = 4; i <= n; i++)
	{
		dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2])%10007;
	}

	cout << dp[n];

	return 0;
}