#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1001];
int sum[1001];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n);

	int result = 0;

	for (int i = 0; i < n; i++)

		for (int j = 0; j <= i; j++)

			result += arr[j];

	cout << result;

	return 0;
}