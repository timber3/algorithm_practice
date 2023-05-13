#include <bits/stdc++.h>
#define div 1000000000
using namespace std;

int n;
long long dp[101][10];


int main()
{
	cin >> n;

	for (int i = 1; i <= 9; i++)
	{
		dp[1][i] = 1;
	}

	for (int i = 2; i <= n; i++)
	{
		for (int j = 0; j <= 9; j++)
		{
			if (j == 0)
			{
				dp[i][j] = dp[i - 1][j + 1] % div;
			}
			else if (j == 9)
			{
				dp[i][j] = dp[i - 1][j - 1] % div;
			}
			else
			{
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % div;
			}
		}
	}

	int sum = 0;

	for (int i = 0; i <= 9; i++)
	{
		sum = (sum + dp[n][i]) % div;
	}

	cout << sum;

	return 0;
}