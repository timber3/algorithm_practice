#include <iostream>

using namespace std;

int main()
{
	int on[10], off[10];

	for ( int i = 0 ; i < 10 ; i ++)
	{
		cin >> off[i] >> on[i];
	}

	int sum = 0;
	int max = 0;
	int max_station = 0;

	for (int i = 0; i < 10; i++)
	{
		sum -= off[i];
		sum += on[i];

		if (sum > max)
		{
			max = sum;
		}
	}

	cout << max << endl;

	return 0;
}