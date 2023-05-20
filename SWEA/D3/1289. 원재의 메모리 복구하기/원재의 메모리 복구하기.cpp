#include <bits/stdc++.h>

using namespace std;

int result;

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		string str;
		cin >> str;
		bool find_one = false;

		for (int i = 0; i < str.size(); i++)
		{
			if (find_one)
			{
				if (str[i] != str[i - 1])
					result++;
			}

			if (str[i] == '1' && !find_one)
			{
				find_one = true;
				result++;
			}

		}

		cout << "#" << t + 1 << " " << result << '\n';

		result = 0;
	}


	return 0;
}