#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;

	int number = 1;
	int temp = 0;
	int clap = 0;

	for (int i = 0; i < N; i++)
	{
		temp = number;
		clap = 0;

		while (temp > 0)
		{
			if ((temp % 10 != 0) && (temp % 10) % 3 == 0)
			{
				clap++;
			}
			temp /= 10;
		}

		if (clap > 0)
		{
			for (int j = 0; j < clap; j++)
			{
				cout << "-";
			}
			cout << " ";
		}
		else
		{
			cout << number << " ";
		}
		number++;

	}

	return 0;
}