#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n;
int arr[11];

int op[4];

int MAX = -1000000001;
int MIN = 1000000001;


int cal(int op, int total, int cnt)
{
	if (op == 0) // plus
	{
		return total + arr[cnt];
	}
	else if (op == 1) // minus
	{
		return total - arr[cnt];
	}
	else if (op == 2) // multiply
	{
		return total * arr[cnt];
	}
	else if (op == 3) // divide
	{
		return total / arr[cnt];
	}
}


void dfs(int cnt, int total)
{
	if (cnt == n)
	{
		if (MAX < total)
			MAX = total;
		if (MIN > total)
			MIN = total;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		if (op[i] != 0)
		{
			op[i]--;
			int result = cal(i, total, cnt);
			dfs(cnt + 1, result);
			op[i]++;
		}
	}
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < 4; i++)
	{
		cin >> op[i];
	}

	dfs(1, arr[0]);

	cout << MAX << endl;
	cout << MIN << endl;

	return 0;
}