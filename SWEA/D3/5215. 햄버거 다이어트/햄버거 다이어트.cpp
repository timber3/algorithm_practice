#include <bits/stdc++.h>

using namespace std;

int n, l;
int dp[21][10001];

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		// l = 제한 칼로리
		cin >> n >> l;

		int score[21];
		int cal[21];

		for (int i = 1; i <= n; i++)
		{
			cin >> score[i] >> cal[i];
		}
		for (int i = 1; i <= n ; i++)
		{
			for (int j = 1; j <= l; j++)
			{
				if (cal[i] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cal[i]] + score[i]);
			}
		}
		cout << "#" << t+1 << " " << dp[n][l] << '\n';
	}

	return 0;
}