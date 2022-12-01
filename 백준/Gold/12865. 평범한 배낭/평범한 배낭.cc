#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int w[101];
int v[101];

int dp[101][100001] = { 0, };

// 처음에 DFS로 시도했을때 정답은 나왔으나 시간초과로 안됨.
int main()
{
	cin >> n >> k;

	for (int i = 1; i <= n; i++)
	{
		cin >> w[i] >> v[i];
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= k; j++)
		{
			if (j - w[i] >= 0)
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
			else
				dp[i][j] = dp[i-1][j];
		}
	}

	cout << dp[n][k];

	return 0;
}