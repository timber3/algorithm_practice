#include <iostream>

using namespace std;

int main()
{
	int arr[9];
	int sum = 0;

	for (int i = 0; i < 9; i++)
	{
		cin >> arr[i];
		sum += arr[i];
	}

	int res1, res2;

	for (int i = 0; i < 9; i++)
		for (int j = 0; j < 9; j++)
			if (arr[i] < arr[j])
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			if (i != j && (sum - (arr[i] + arr[j])) == 100)
			{
				res1 = i;
				res2 = j;
			}
		}
	}

	for (int i = 0; i < 9; i++)
	{
		if (i == res1 || i == res2)
			continue;
		cout << arr[i] << " ";
	}

	return 0;
}