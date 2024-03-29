#include <bits/stdc++.h>

using namespace std;

int n;
long long dp[91];

int main()
{
	// 이친수는 1로 시작한다.
	// 이친수에서는 1이 연속해서 두번이상 등장하지 않는다.
	// 이친수는 1 10 100 101 1001 10101 101001 같은 숫자들이다.

	cin >> n;

	// 1 자리 : 1
	// 2 자리 : 10
	// 3 자리 : 101 100
	// 4 자리 : 1000 1001 1010
	// 5 자리 : 10000 10001 10010 10100 10101
	// 6 자리 : 101000 101001 101010 100000 100001 100010 100100 100101

	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 2;

	for (int i = 4; i <= n; i++)
	{
		dp[i] = dp[i-1] + dp[i-2];
	}

	cout << dp[n] << endl;

	return 0;
}