#include <bits/stdc++.h>

using namespace std;

int n;
int dp[5001];

int main()
{
	cin >> n;

	for (int i = 0; i <= n; i++)
	{
		dp[i] = 999999999;
	}

	dp[3] = 1;
	dp[5] = 1;

	for (int i = 6; i <= n; i++)
	{
		dp[i] = min(dp[i - 3] + 1, dp[i - 5] + 1);
	}

	if(dp[n] >= 999999999)
		cout << "-1";
	else
		cout << dp[n];


	return 0;
}