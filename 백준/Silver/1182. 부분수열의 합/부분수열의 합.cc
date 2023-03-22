#include <bits/stdc++.h>

using namespace std;

int n, s;
int result;
int arr[21];

void bt(int sum, int cnt)
{
	if (cnt == n)
	{
		if (sum == s)
			result++;
		return;
	}

	bt(sum, cnt + 1);

	bt(sum + arr[cnt], cnt + 1);

}

int main()
{
	cin >> n >> s;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	bt(0, 0);

	if (s == 0)
		result--;

	cout << result;

	return 0;
}