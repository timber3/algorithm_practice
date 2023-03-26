// 5:33 ~ 5:48
#include <bits/stdc++.h>

using namespace std;

int n, m;
int arr[100001];
long long dp[100001];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		dp[i] = dp[i - 1] + arr[i];
	}

	for (int i = 0; i < m; i++)
	{
		int s, e;
		cin >> s >> e;
		cout << dp[e] - dp[s-1] << "\n";
	}

	return 0;
}