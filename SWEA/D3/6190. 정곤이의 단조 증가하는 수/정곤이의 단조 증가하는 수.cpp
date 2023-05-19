#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1001];
int Max = -1;

int danzo(int val)
{
	string temp = to_string(val);

	if (val < 10)
		return -1;

	else
	{
		for (int i = 1; i < temp.size(); i++)
		{
			int bef = temp[i - 1] - '0';
			int cur = temp[i] - '0';

			if (bef > cur)
				return -1;
		}

		// 여기까지 왔으면 단조임
		return val;
	}
}

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> n;

		for (int i = 0; i < n; i++)
		{
			cin >> arr[i];
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i != j)
				{
					if (arr[i] * arr[j] > Max)
					{
						int result = danzo(arr[i] * arr[j]);

						if (result > Max)
						{
							Max = result;
						}
					}
				}
			}
		}

		cout << "#" << t + 1 << " " << Max << '\n';
		
		Max = -1;
	}

	return 0;
}