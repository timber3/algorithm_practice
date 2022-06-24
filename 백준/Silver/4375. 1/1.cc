#include <iostream>

using namespace std;

int main(void)
{
	int n = 0;


	while (cin >> n)
	{
		int val = 1;
		int k = 1;

		while (1)
		{
			if (val % n == 0)
				break;
			else
			{
				k++;
				val = (val * 10) + 1;	// 1 이면 11로 만드는 작업.
				val %= n;
			}
		}

		cout << k << endl;
	}

	return 0;
}