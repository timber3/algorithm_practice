#include <iostream>

using namespace std;

int main()
{
	int H, W;

	cin >> H >> W;

	int* arr = new int[W];

	int lmax = 0;
	int rmax = 0;
	int sum = 0;

	// 바닥은 항상 막혀있다고 가정한다.

	for ( int i = 0 ; i < W ; i ++)
		cin >> arr[i];

	for (int i = 1; i < W-1; i++)
	{
		lmax = 0;
		rmax = 0;

		for (int j = 0; j < i; j++)
		{
			if (arr[i] < arr[j] && arr[j] > lmax)
			{
				lmax = arr[j];
			}
		}
		for (int j = W-1; j > i ; j--)
		{
			if (arr[i] < arr[j] && arr[j] > rmax)
			{
				rmax = arr[j];
			}
		}

		if (lmax != 0 && rmax != 0)
		{
			if (rmax > lmax)
			{
				sum += lmax - arr[i];
			}
			else
			{
				sum += rmax - arr[i];
			}
		}
	}

	cout << sum;

	return 0;
}