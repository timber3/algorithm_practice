#include <bits/stdc++.h>

using namespace std;

int arr[1000001] = { 0, };

int t;
int n;
int stock;
long long money;
int Max;

int main()
{
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		money = 0;
		cin >> n;

		for (int j = 0; j < n; j++)
		{
			cin >> arr[j];
		}

		Max = arr[n - 1];

		// 뒤에서부터 확인한다.
		for (int j = n-1; j >= 1; j--)
		{
			// 앞에 값이 Max 보다 크거나 같으면
			if (arr[j - 1] >= Max)
			{
				Max = arr[j - 1];
			}
			// 앞에 값이 Max 보다 작으면
			else
			{
				money += (Max - arr[j - 1]);
			}
		}

		cout << money << "\n";

	}

}