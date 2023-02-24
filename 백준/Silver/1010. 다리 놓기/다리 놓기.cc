#include <iostream>

using namespace std;

int t, n, m;
long long result;

int main()
{
	cin >> t;

	while (t--)
	{
		cin >> n >> m;

		long long a = 1;

		int cnt = 1;

		for (int i = m; i > m-n; i--)
		{
			a *= i;
			a /= cnt++;
		}

		result = a;

		cout << result << "\n";
	}

	return 0;
}