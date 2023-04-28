#include <bits/stdc++.h>

using namespace std;

int n, k;
string str;

map<string, int> m;

int main()
{
	int t;
	cin >> t;

	for (int T = 0; T < t; T++)
	{
		cin >> n >> k;

		cin >> str;

		int num_line = n / 4;

		for (int j = 0; j < num_line; j++)
		{
			for (int i = 0; i < 4; i++)
			{
				m.insert({ str.substr(i*num_line, num_line),0 });
			}

			str.insert(str.begin(), str[n - 1]);
			str.pop_back();

		}

		int cnt = 0;

		string result_str;

		for (auto iter = m.begin(); iter != m.end(); iter++)
		{
			if (cnt == m.size()-k)
				result_str = iter->first;
			cnt++;
		}

		int sum = 0;

		for (int i = 0; i < result_str.size(); i++)
		{
			char c = result_str[i];
			// 문자라면
			if (c >= 65)
			{
				sum += pow(16, result_str.size() - i - 1) * (c-55);
			}
			// 숫자라면
			else
			{
				sum += pow(16, result_str.size() - i - 1) * (c - '0');
			}
		}

		cout << "#" << T+1 << " " <<  sum << '\n';

		m.clear();
	}

	return 0;
}