#include <bits/stdc++.h>

using namespace std;

int n;
int arr[601];
int Min = 999999999;

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n);

	for (int i = 0; i < n - 3; i++)
	{
		for (int j = i + 3; j < n; j++)
		{
			// i, j = 엘사 눈사람
			// st, en = 안나 눈사람
			int st = i + 1;
			int en = j - 1;

			while (st < en)
			{
				int elsa = arr[i] + arr[j];
				int anna = arr[st] + arr[en];

				int result = elsa - anna;

				Min = min(Min, abs(result));

				if (result > 0)
				{
					st = st + 1;
				}
				else
				{
					en = en - 1;
				}
			}
		}
	}

	cout << Min;

	return 0;
}