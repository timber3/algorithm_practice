#include <iostream>

using namespace std;

int a, b, c, x, y;
int flag = 0;
int sum = 0;

int main()
{
	cin >> a >> b >> c >> x >> y;

	if (a + b > 2 * c)
	{
		flag = 1;
		while (!(x == 0 || y == 0))
		{
			sum += 2 * c;
			x--;
			y--;
		}

		if (x == 0)
		{
			if (b > 2 * c)
			{
				sum += 2 * c * y;
			}
			else
			{
				sum += b * y;
			}
		}
		else
		{
			if (a > 2 * c)
			{
				sum += 2 * c * x;
			}
			else
			{
				sum += a * x;
			}
		}
	}

	if (flag == 0)
	{
		sum += b * y;
		sum += a * x;
	}

	cout << sum;
	return 0;
}