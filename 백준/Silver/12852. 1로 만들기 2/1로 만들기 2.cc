#include <bits/stdc++.h>

using namespace std;

int n;
int dp[1000002];

int main()
{
	cin >> n;

	dp[1] = 0;

	for (int i = 2; i <= n; i++)
	{
		dp[i] = dp[i - 1] + 1;

		if (i % 2 == 0)
		{
			dp[i] = min(dp[i], dp[i / 2] + 1);
		}
		if (i % 3 == 0)
		{
			dp[i] = min(dp[i], dp[i / 3] + 1);
		}

	}

	cout << dp[n] << "\n";

	int cnt = n;
	cout << n << " ";

	while (cnt > 1)
	{
		int val = cnt - 1;

		if (cnt % 2 == 0)
		{
			if (dp[val] > dp[cnt / 2])
			{
				val = cnt / 2;
			}
		}
		if (cnt % 3 == 0)
		{
			if (dp[val] > dp[cnt / 3])
			{
				val = cnt / 3;
			}
		}

		cout << val << " ";

		cnt = val;
	}

	return 0;
}