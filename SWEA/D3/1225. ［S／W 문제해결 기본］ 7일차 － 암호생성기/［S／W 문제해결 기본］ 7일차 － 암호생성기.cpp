#include <bits/stdc++.h>

using namespace std;

vector<int> v;

bool cycle()
{
	for (int i = 0; i < 5; i++)
	{
		if (v[0] - (i + 1) <= 0)
		{
			v.push_back(0);
			v.erase(v.begin());
			return true;
		}

		v.push_back(v[0] - (i+1));
		v.erase(v.begin());
	}

	return false;
}

int main()
{
	for (int t = 0; t < 10; t++)
	{
		int T;
		cin >> T;

		for (int i = 0; i < 8; i++)
		{
			int temp;
			cin >> temp;
			v.push_back(temp);
		}

		while (1)
		{
			bool c_c = cycle();
			if (c_c)
				break;
		}

		cout << "#" << T << " ";

		for (int i = 0; i < 8; i++)
		{
			cout << v[i] << " ";
		}

		cout << '\n';

		v.clear();

	}

	return 0;
}