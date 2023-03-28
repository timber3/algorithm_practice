#include <bits/stdc++.h>

using namespace std;


int n;
int Max = 0;
int sum = 0;
int arr[100001];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n, greater<>());

	for (int i = 0; i < n; i++)
	{
		if (arr[i] * (i+1) > Max )
		{
			Max = arr[i] * (i+1);
		}
	}

	cout << Max;
	return 0;
}