#include <iostream>

using namespace std;

int main()
{
	int N, K;
	int arr[10000];

	cin >> N >> K;

	//int* arr = new int[N];

	int count = 0;

	for (int i = 1; i <= N; i++)
	{
		if (N % i == 0)
		{
			arr[count] = i;
			count++;
		}
	}

	if (count + 1 <= K)
	{
		cout << '0' << endl;
	}
	else
	{
		cout << arr[K - 1] << endl;
	}

	return 0;
}