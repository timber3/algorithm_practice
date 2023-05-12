#include <bits/stdc++.h>

using namespace std;

int n;
long long dp[101];

int main()
{
	// 1 1 1 2 2 3 4 5 7 9 12 16
	int t;
	cin >> t;

	for (int T = 0; T < t; T++)
	{
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		cin >> n;

		for (int i = 4; i <= n; i++)
		{
			dp[i] = dp[i - 2] + dp[i - 3];
		}
		cout << dp[n] << '\n';

		fill(dp, dp + 100, 0);
	}

	return 0;
}