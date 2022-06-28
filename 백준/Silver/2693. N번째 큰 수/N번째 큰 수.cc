#include <iostream>

using namespace std;

int main()
{
	int arr[10];
	int max = 0;
	int T;

	cin >> T;

	int n = T;

	int* res = new int[T];

	while (T)
	{
		for (int i = 0; i < 10; i++)
			cin >> arr[i];

		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if (arr[j] < arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		res[T] = arr[2];
		T--;
	}

	for (int i = n; i > 0 ; i--)
	{
		cout << res[i] << endl;
	}

	return 0;
}