#include <bits/stdc++.h>

using namespace std;

int n, m;
int Map[15][15];
int result;

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> n >> m;
		int Max = 0;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> Map[i][j];
			}
		}

		// M 이 3이고 N 이 5면
		// x 가 최대 2다. 그래야 2, 3, 4, 까지 범위가 생기기 때문 (N - M)

		for (int a = 0; a  < n - m + 1; a++)
		{
			for (int b = 0; b < n - m + 1; b++)
			{
				int sum = 0;

				for (int i = a; i < a +m; i++)
				{
					for (int j = b; j < b + m; j++)
					{
						sum += Map[i][j];
					}
				}

				if (Max < sum)
				{
					Max = sum;
				}
			}
		}

		cout << "#" << t + 1 << " " << Max << '\n';
	}

	return 0;
}