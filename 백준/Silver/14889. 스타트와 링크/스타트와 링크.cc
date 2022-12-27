#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n;

int arr[21][21] = {0, };

int Min = 999999999;

int team1[10];
int team2[10];

vector<int> t1;
vector<int> t2;


int team1sum = 0;
int team2sum = 0;

int visited[21] = { 0, };

void dfs(int cnt, int pos)
{
	if (cnt == n/2)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i != j && visited[i] == 1 && visited[j] == 1)
				{
					team1sum += arr[i][j];
				}
				if (i != j && visited[i] == 0 && visited[j] == 0)
				{
					team2sum += arr[i][j];
				}
			}
		}

		if (Min > abs(team1sum - team2sum))
		{
			Min = abs(team1sum - team2sum);
		}
		return;
	}

	for (int i = pos; i < n; i++)
	{
		if (!visited[i])
		{
			visited[i] = 1;
			dfs(cnt + 1, i+1);
			visited[i] = 0;
			team1sum = 0;
			team2sum = 0;
		}
	}
}


int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> arr[i][j];
		}
	}

	dfs(0, 0);

	cout << Min;

	return 0;
}
