#include <bits/stdc++.h>
#define ll long long

using namespace std;

ll power(ll a, ll b, ll m)
{
	if(b == 1)
		return a % m;

	ll val = power(a, b / 2, m);
	val = val * val % m;

	if (b % 2 == 0)
		return val;

	return val * a % m;
}

int main()
{
	ll a, b, c;

	cin >> a >> b >> c;

	cout << power(a, b, c);

	return 0;
}