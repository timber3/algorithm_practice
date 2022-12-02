#include <iostream>
#include <string>

using namespace std;

string str;

int result = 1;
int c = 26;
int d = 10;

int main()
{
	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] == 'c')
		{
			result *= c;
			if (str[i + 1] == 'c')
				c = 25;
			else
				d = 10;
		}

		if (str[i] == 'd')
		{
			result *= d;
			if (str[i + 1] == 'd')
				d = 9;
			else
				c = 26;
		}
	}
	cout << result;

	return 0;
}