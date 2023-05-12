#include <bits/stdc++.h>

using namespace std;

int n;
long long dp[1500005];
int term[1500005];
int pay[1500005];

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> term[i] >> pay[i];
	}

	for (int i = n; i >= 1; i--)
	{
		if (i + term[i] <= n + 1) // 일을 했을 때 퇴사일보다 전일 경우(가능할 경우)
		{
			dp[i] = max(dp[i + term[i]] + pay[i], dp[i + 1]);
		}
		else
		{
			dp[i] = dp[i + 1];
		}
	}

	cout << *max_element(dp + 1, dp + n + 1);
	
	return 0;
}