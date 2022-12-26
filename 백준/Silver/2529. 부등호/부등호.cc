#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int k;
char input[10];
int arr[10];
int arr2[10];

int visited[10] = { 0, };

int flag = 0;

int Case1 = 0;
int Case2 = 0;

bool cal(int cnt, int a, int b)
{
	if (input[cnt] == '>')
	{
		if (a > b)
			return true;
	}
	if (input[cnt] == '<')
	{
		if (a < b)
			return true;
	}
	return false;
}

void dfs(int cnt)
{
	if (flag == 1)
		return;

	if (cnt == k)
	{
		for (int i = 0; i < k + 1; i++)
		{
			cout << arr[i];
		}
		cout << endl;
		flag = 1;
		return;
	}


	if (Case1)
	{
		for (int i = 9; i >= 0; i--)
		{
			if (!visited[i])
			{
				if (cal(cnt, arr[cnt], i))
				{
					visited[i] = 1;
					arr[cnt + 1] = i;
					dfs(cnt + 1);
					visited[i] = 0;
				}
			}
		}
	}

	if (Case2)
	{
		for (int i = 0; i <= 9; i++)
		{
			if (!visited[i])
			{
				if (cal(cnt, arr[cnt], i))
				{
					visited[i] = 1;
					arr[cnt + 1] = i;
					dfs(cnt + 1);
					visited[i] = 0;
				}
			}
		}
	}

}

int main()
{
	cin >> k;

	for (int i = 0; i < k; i++)
	{
		cin >> input[i];
	}

	Case1 = 1;

	for (int i = 9; i >= 0 ; i--)
	{
		if (flag == 0)
		{
			visited[i] = 1;
			arr[0] = i;
			dfs(0);
		}
		visited[i] = 0;
	}

	Case1 = 0;
	Case2 = 1;
	flag = 0;

	for (int i = 0; i <= 9; i++)
	{
		if (flag == 0)
		{
			visited[i] = 1;
			arr[0] = i;
			dfs(0);
		}
		visited[i] = 0;
	}

	return 0;
}