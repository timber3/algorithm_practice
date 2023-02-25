#include <bits/stdc++.h>

using namespace std;

int n;

int dp[1000000] = { 0, };

int main()
{
	cin >> n;

	// 1. 3으로 나눈다.
	// 2. 2로 나눈다.
	// 3. 1을 뺀다.

	// 결과로 1을 만들어 내야한다.

	dp[1] = 0;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;

	for (int i = 5; i <= n; i++)
	{
		int div2 = 0;
		int div3 = 0;

		if (i % 2 == 0)
			div2 = 1;
		if (i % 3 == 0)
			div3 = 1;

		if (!(div2 && div3))
		{
			if (div2)
			{
				dp[i] = min(dp[i / 2] + 1, dp[i-1] +1);
			}
			else if (div3)
			{
				dp[i] = min(dp[i / 3] + 1, dp[i - 1] + 1);
			}
			else
			{
				dp[i] = dp[i - 1] + 1;
			}
		}
		else
		{
			dp[i] = min(dp[i / 2] + 1, dp[i / 3] + 1);
		}
	}

	cout << dp[n];

	return 0;
}