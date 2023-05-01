#include <bits/stdc++.h>

using namespace std;

vector<int> v;

int main()
{
	for (int T = 0; T < 10; T++)
	{
		int n;
		cin >> n;

		int result = 0;

		for (int i = 0; i < 100; i++)
		{
			int temp;
			cin >> temp;
			v.push_back(temp);
		}

		for (int i = 0; i < n; i++)
		{
			int Max = -1;
			int Min = 999;
			int Max_idx;
			int Min_idx;

			for (int j = 0; j < 100; j++)
			{
				if (v[j] > Max)
				{
					Max = v[j];
					Max_idx = j;
				}
				if (v[j] < Min)
				{
					Min = v[j];
					Min_idx = j;
				}
			}

			v[Max_idx] -= 1;
			v[Min_idx] += 1;

			Max = -1;
			Min = 999;

			for (int j = 0; j < 100; j++)
			{
				if (v[j] >= Max)
				{
					Max = v[j];
					Max_idx = j;
				}
				if (v[j] <= Min)
				{
					Min = v[j];
					Min_idx = j;
				}
			}

			int dif = Max - Min;

			if (i == n - 1)
			{
				result = dif;
			}

			if (dif == 0 || dif == 1)
			{
				result = dif;
				break;
			}
		}

		cout << "#" << T+1 << " " << result << '\n';

		v.clear();
	}


	return 0;
}