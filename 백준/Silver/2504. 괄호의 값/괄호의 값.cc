#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(void)
{
	string str;

	stack<char> st;
	int temp = 1;
	int sum = 0;
	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] == '(')
		{
			st.push(str[i]);
			temp *= 2;
		}
		else if (str[i] == '[')
		{
			st.push(str[i]);
			temp *= 3;
		}
		else if (str[i] == ')')
		{
			if (st.empty() == 1 || st.top() != '(')
			{
				cout << 0 << endl;
				exit(0);
			}
			else
			{
				if (str[i - 1] == '(')
				{
					sum += temp;
					temp /= 2;
				}
				else
				{
					temp /= 2;
				}
				st.pop();
			}
		}
		else if (str[i] == ']')
		{
			if (st.empty() == 1 || st.top() != '[')
			{
				cout << 0 << endl;
				exit(0);
			}
			else
			{
				if (str[i - 1] == '[')
				{
					sum += temp;
					temp /= 3;
				}
				else
				{
					temp /= 3;
				}
				st.pop();
			}
		}
	}

	if (st.size() != 0)
	{
		cout << 0 << endl;
		return 0;
	}

	cout << sum << endl;
	return 0;
}