#include <bits/stdc++.h>

using namespace std;

int n;
int arr[100001];
int visited[100001];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	int st = 0;
	int en = 0;
	long long result = 0;

	for (int st = 0; st < n; st++)
	{
		while (en < n)
		{
			if (visited[arr[en]])
				break;
			visited[arr[en]] = 1;
			en++;
		}

		result += (en - st);

		visited[arr[st]] = 0;
	}

	cout << result;

	return 0;
}