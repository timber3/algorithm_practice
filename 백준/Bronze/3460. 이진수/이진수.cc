#include <iostream>

using namespace std;

int main(void)
{
	int n, T;

	int count = 0;

	cin >> T;

	for (int i = 0; i < T; i++)
	{
		cin >> n;

		int arr[200] = { 0, };

		while (n >= 2)
		{
			if (n % 2 == 1)
			{
				arr[count++] = 1;
			}

			else
			{
				arr[count++] = 0;
			}
			n /= 2;
		}

		if (n == 1)
		{
			arr[count++] = 1;
		}

		for (int i = 0; i < count; i++)
		{
			if (arr[i] == 1)
			{
				cout << i << " ";
			}
		}

		cout << endl;

		count = 0;

		for (int i = 0; i < 200; i++)
		{
			arr[i] = 0;
		}
	}


	return 0;
}