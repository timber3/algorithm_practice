#include <iostream>

using namespace std;

int arr[5];
int sum = 0;

int main()
{
	for (int i = 0; i < 5; i++)
	{
		cin >> arr[i];
		arr[i] = arr[i] * arr[i];
		sum += arr[i];
	}

	int result = sum % 10;

	cout << result;

}