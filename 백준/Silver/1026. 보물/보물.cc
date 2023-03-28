#include <bits/stdc++.h>

using namespace std;

int n;
int a[51];
int b[51];
int sum;

int main()
{

	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> a[i];

	for (int i = 0; i < n; i++)
		cin >> b[i];

	sort(a, a + n);
	sort(b, b + n);

	for (int i = 0; i < n; i++)
	{
		sum += a[n-1-i] * b[i];
	}

	cout << sum;

	return 0;
}