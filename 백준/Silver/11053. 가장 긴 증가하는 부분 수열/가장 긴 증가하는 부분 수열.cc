#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1001];
int dp[1001] = { 0, };
int result = 0;

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++)
	{
		int Max = 0;

		for (int j = 0; j < i; j++)
		{
			if (arr[i] > arr[j])
			{
				if (Max < dp[j])
					Max = dp[j];
			}
		}
		dp[i] = Max +1;

		result = max(dp[i], result);
	}

	cout << result;

	return 0;
}