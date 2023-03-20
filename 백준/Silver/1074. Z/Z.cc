#include <bits/stdc++.h>
#define ll long long

using namespace std;

// 다음 방문할 x, y 좌표  , 현재 깊이
int z(int x, int y, int n)
{
	if (n == 0)
		return 0;
	// 2의 n-1제곱형태
	ll half = (ll)1 << (n - 1);
	// 목적지가 1사분면 일때
	if (x < half && y >= half)
		return half * half + z(x, y - half, n - 1);
	// 2사분면 일때
	if (x < half && y < half)
		return z(x, y, n - 1);
	// 3사분면 일때
	if (x >= half && y < half)
		return 2 * half * half + z(x - half, y, n - 1);
	// 4사분면 일때
	return 3 * half * half + z(x - half, y - half, n - 1);
}

int main()
{
	ll n, r, c;

	cin >> n >> r >> c;

	cout << z(r, c, n);

	return 0;
}