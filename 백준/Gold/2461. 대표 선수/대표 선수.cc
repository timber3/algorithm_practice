#include <bits/stdc++.h>

using namespace std;

int n, m;
int arr[1001][1001];
int idx[1001];
long long result = 9999999999;

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> arr[i][j];
		}
	}

	// 최솟값끼리 비교해서 

	for (int i = 0; i < n; i++)
	{
		sort(arr[i], arr[i] + m);
	}

	while (1)
	{
		long long Max = 0;
		long long Min = 9999999999;
		int Min_idx = 0;
		int Max_idx = 0;

		for (int i = 0; i < n; i++)
		{
			if (arr[i][idx[i]] < Min)
			{
				Min = arr[i][idx[i]];
				Min_idx = i;
			}
			
			if (arr[i][idx[i]] > Max)
			{
				Max = arr[i][idx[i]];
				Max_idx = i;
			}
		}

		result = min(Max - Min, result);

		idx[Min_idx]++;

		if (idx[Min_idx] == m)
			break;
	}

	cout << result;

	return 0;
}