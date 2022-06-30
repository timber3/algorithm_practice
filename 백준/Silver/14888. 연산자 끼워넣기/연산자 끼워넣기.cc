#include <iostream>

using namespace std;

int N;
int arr[11];
int operators[4];
int index = 0;
int idx = 0;

int sum = 0;
int Max = -1000000001;
int Min = 1000000001;

void recursive(int sum, int idx)
{
	if (idx == N)
	{
		if (sum > Max)
		{
			Max = sum;
		}
		if (sum < Min)
		{
			Min = sum;
		}
		return;
	}

	for (int i = 0; i < 4; i++)
	{

		if (operators[i] > 0)
		{
			operators[i]--;

			if ( i == 0)
				recursive(sum + arr[idx], idx+1);
			else if (i == 1)
				recursive(sum - arr[idx], idx+ 1);
			else if (i == 2)
				recursive(sum * arr[idx], idx + 1);
			else
				recursive(sum / arr[idx], idx + 1);
			operators[i] ++;	// recursive 끝나고 다음 계산을 위하여 연산자 개수를 올려줘야함.
		}
	}
	return;
}

int main()
{

	cin >> N;
	
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < 4; i++)
	{
		cin >> operators[i];
	}

	//all case search
	recursive(arr[0], 1);

	cout << Max << endl;
	cout << Min << endl;


	return 0;
}