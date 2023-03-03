#include <bits/stdc++.h>

using namespace std;

int n;
int arr[100001];
int dp[100001] = { 0, };
int Max = -9999;

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		dp[i] = arr[i];
	}

	dp[1] = arr[1];

	for (int i = 1; i <= n; i++)
	{
		dp[i] = max(dp[i], dp[i - 1] + arr[i]);

		if (Max < dp[i])
			Max = dp[i];
	}

	cout << Max;

	return 0;
}