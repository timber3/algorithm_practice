#include <iostream>

using namespace std;

int main()
{
	int arr[10000] = { 0, };
	int count = 0;

	for (int i = 1; i < 100; i++)
	{
		for (int j = 0; j < i; j++)
		{
			arr[count++] = i;
		}
	}

	int A, B;
	int sum = 0;
	cin >> A >> B;

	for (int i = A-1; i <=B-1; i++)
	{
		sum += arr[i];
	}

	cout << sum << endl;

	return 0;
}