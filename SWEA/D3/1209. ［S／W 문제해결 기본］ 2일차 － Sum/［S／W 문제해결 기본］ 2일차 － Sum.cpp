#include <bits/stdc++.h>

using namespace std;

int Map[101][101];
int Max = 0;

void cal()
{
	for (int i = 0; i < 100; i++)
	{
		int sum_ho = 0;
		int sum_ver = 0;

		int sum1 = 0;
		int sum2 = 0;

		sum1 += Map[i][i];
		sum2 += Map[99 - i][i];

		for (int j = 0; j < 100; j++)
		{
			sum_ho += Map[i][j];
			sum_ver += Map[j][i];

			Max = max(sum_ho, max(sum_ver, Max));
		}

		Max = max(sum1, max(sum2, Max));
	}
}

int main()
{
	int caseNum = 0;

	for (int t = 0; t < 10 ; t++)
	{
		cin >> caseNum;

		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				cin >> Map[i][j];
			}
		}

		cal();

		cout << "#" << t + 1 << " " << Max << '\n';

		for (int i = 0; i < 100; i++)
		{
			fill(Map[i], Map[i] + 100, 0);
		}

		Max = 0;
	}

	return 0;
}