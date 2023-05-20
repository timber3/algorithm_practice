#include <bits/stdc++.h>

using namespace std;

int n, m, k;
bool result = true;
int arr[101];

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		// n 명의 사람들이 오는데
		// m초의 시간을 들이면 k개의 붕어빵을 만들 수 있다.
		cin >> n >> m >> k;

		for (int i = 0; i < n; i++)
		{
			// 각 사람은 arr[i] 시간에 도착한다.
			cin >> arr[i];
		}

		sort(arr, arr + n);

		for (int i = 0; i < n; i++)
		{
			if (i + 1 > (arr[i] / m) * k )
			{
				result = false;
			}
		}

		if ( result )
			cout << "#" << t + 1 << " " << "Possible" << '\n';
		else
			cout << "#" << t + 1 << " " << "Impossible" << '\n';

		result = true;

	}

	return 0;
}