#include <bits/stdc++.h>
#define endl "\n"

using namespace std;

int input;
int k = 1;

int number[13];
int result[13];

int visited[13] = { 0, };

// k개의 숫자를 뽑았을때 중복되지 않게 모든 경우의 조합을 구하라. 
// 조합 문제 - DFS

void dfs( int cnt )
{
	if (cnt == 6)
	{
		for (int i = 0; i < 6; i++)
		{
			cout << result[i+1] << " ";
		}

		cout << endl;
		return;
	}

	for (int i = cnt; i < k; i++)
	{
		if (!visited[i])
		{
			visited[i] = 1;
			if (number[i] > result[cnt])
			{
				result[cnt+1] = number[i];
				dfs(cnt + 1);
			}
			visited[i] = 0;
		}
	}
}

int main()
{
	while (1)
	{
		cin >> k;

		if (k == 0)
		{
			break;
		}

		for (int i = 0; i < k; i++)
		{
			cin >> number[i];
		}

		dfs(0);

		cout << endl;
	}
	return 0;
}