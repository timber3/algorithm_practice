#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> coin;
long long dp[10001];

int main()
{
	// 동전의 종류가 주어질 때 주어진 금액을 만드는 모든 방법

	int t;

	cin >> t;

	for (int T = 0; T < t; T++)
	{
		cin >> n;

		for (int N = 0; N < n; N++)
		{
			int temp;
			cin >> temp;
			coin.push_back(temp);
		}

		int target;

		cin >> target;

		dp[0] = 1;

		for (int i = 0; i < coin.size(); i++)
		{
			for (int j = coin[i]; j <= target; j++)
			{
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		cout << dp[target] << '\n';

		coin.clear();

		fill(dp, dp + 10000, 0);
	}

	return 0;
}