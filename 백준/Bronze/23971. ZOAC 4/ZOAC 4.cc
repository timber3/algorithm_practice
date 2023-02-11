#include <bits/stdc++.h>

using namespace std;

int w, h;
int n, m;

int main()
{
	cin >> h >> w >> n >> m;

	int a = 0;
	int b = 0;

	int x1 = h / (n + 1);
	int x2 = h % (n + 1);

	if (x2 > 0)
		x1 += 1;

	a = x1;

	int y1 = w / (m + 1);
	int y2 = w % (m + 1);

	if (y2 > 0)
		y1 += 1;

	b = y1;

	cout << a * b;

	return 0;
}