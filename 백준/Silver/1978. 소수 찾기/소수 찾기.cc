#include <iostream>

using namespace std;

int main()
{

	int N;
	int count = 0;
	int flag = 0;
	cin >> N;

	int* arr = new int[N];

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}

	for (int j = 0; j < N; j++)
	{
		flag = 0;

		if (arr[j] == 1)
			continue;

		for (int i = 2; i < arr[j]; i++)
		{
			if (arr[j] % i == 0)
			{
				flag = 1;
				break;
			}
		}

		if (flag == 0)
			count++;

	}

	cout << count << endl;

	return 0;

}