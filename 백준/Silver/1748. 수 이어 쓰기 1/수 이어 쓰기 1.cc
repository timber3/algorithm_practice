#include <bits/stdc++.h>

using namespace std;

int n;
int result;

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i*=10)
	{
		result += n - i + 1;
	}

	cout << result;

	return 0;
}