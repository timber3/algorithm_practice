#include <bits/stdc++.h>

#define ll long long

using namespace std;

ll n;
int dp[1000001];

// DP(12) = DP(4) + 1
// DP(12) = DP(6) + 1
// DP(12) = DP(11) + 1

// => DP(12) = min(DP(4) + 1, DP(6) + 1 , DP(11) + 1)
// => DP(k) = min(DP(k/3) + 1 , DP(k/2) + 1, DP(k-1) + 1)

int main()
{
	cin >> n;

	dp[1] = 0;

	for (int i = 2; i <= n; i++)
	{
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0)
			dp[i] = min(dp[i], dp[i / 2] + 1);
		if (i % 3 == 0)
			dp[i] = min(dp[i], dp[i / 3] + 1);
	}

	cout << dp[n];

	return 0;
}