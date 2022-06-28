#include <iostream>

using namespace std;

//최대 공약수
int gcd(int a, int b)
{
	while (b != 0)
	{
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}

// 최소 공배수
int lcm(int a, int b)
{
	return a * b / gcd(a, b);
}


int main()
{
	int a, b;

	cin >> a >> b;

	cout << gcd(a, b) << "\n" << lcm(a, b);

	return 0;

}