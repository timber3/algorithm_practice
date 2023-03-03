#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1001];
int dp[1001];
int Max = -9999;

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		dp[i] = arr[i];
		int Max_dp = 0;

		for (int j = i; j > 0; j--)
		{
			if (arr[i] > arr[j] && Max_dp < dp[j])
			{
				Max_dp = dp[j];
			}
			dp[i] = Max_dp + arr[i];
		}

		if (Max < dp[i])
			Max = dp[i];
	}

	cout << Max;

	return 0;
}