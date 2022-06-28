#include <iostream>

using namespace std;

int main()
{
	int M, N;
	int flag = 0;
	int sum = 0;
	int min = 0;
	int min_flag = 0;
	int val_flag = 0;

	cin >> M >> N;

	for (int i = M; i <= N; i++)
	{
		if (i == 1)
			continue;

		flag = 0;

		for (int j = 2; j < i; j++)
		{
			if (i % j == 0)
			{
				flag = 1;	// 소수가 아님
				break;
			}
		}

		if (flag == 0) // 소수라면
		{
			val_flag = 1;
			if (min_flag == 0)
			{
				min = i;
				min_flag = 1;
			}
			sum += i;
		}
	}

	if (val_flag == 1)
	{
		cout << sum << "\n" << min;
	}
	else
	{
		cout << "-1";
	}

	return 0;
}