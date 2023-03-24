#include <bits/stdc++.h>

using namespace std;

int n;
int r[1001];
int g[1001];
int b[1001];

int dp[1001][3];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> r[i] >> g[i] >> b[i];
	}
	
	// dp[i][0] = i번째 까지 칠할 때 최솟값 ( i는 빨간색임 )
	// dp[i][1] = i번째 까지 칠할 때 최솟값 ( i는 초록색임 )
	// dp[i][2] = i번째 까지 칠할 때 최솟값 ( i는 파란색임 )

	dp[0][0] = r[0];
	dp[0][1] = g[0];
	dp[0][2] = b[0];

	for (int i = 1; i <= n; i++)
	{
		dp[i][0] = min(dp[i - 1][1] + r[i], dp[i - 1][2] + r[i]);
		dp[i][1] = min(dp[i - 1][0] + g[i], dp[i - 1][2] + g[i]);
		dp[i][2] = min(dp[i - 1][1] + b[i], dp[i - 1][0] + b[i]);
	}

	cout << min(min(dp[n][0], dp[n][1]), dp[n][2]);

	return 0;
}