#include <bits/stdc++.h>

using namespace std;

int n, m;
int k;
int know_people[51] = { 0, };
int result = 0;
int visited[51] = { 0, };
int meet[51][51] = { 0, };
vector<int> party[51];
queue<int> q;


void bfs()
{
	while (!q.empty())
	{
		int cur = q.front();

		q.pop();

		visited[cur] = 1;
		know_people[cur] = 1;

		for (int i = 1; i <= n; i++)
		{
			if (meet[cur][i] == 1 && !visited[i])
			{
				know_people[i] = 1;
				q.push(i);
			}
		}
	}
}

void solve()
{
	bfs();

	for (int i = 0; i < m; i++)
	{
		int can_gura = 1;
		for (int j = 0; j < party[i].size(); j++)
		{
			if (know_people[party[i][j]])
				can_gura = 0;
		}

		if (can_gura)
		{
			result++;
		}
	}
}


int main()
{
	cin >> n >> m >> k;

	for (int i = 0; i < k; i++)
	{
		int t;
		cin >> t;
		know_people[t] = 1;
		q.push(t);
	}

	for (int i = 0; i < m; i++)
	{
		// 몇명이 파티에 참석하는지?
		int num;
		cin >> num;
		for (int j = 0; j < num; j++)
		{
			int temp;
			cin >> temp;
			party[i].push_back(temp);
		}

		// 누가 누굴 만나는지 기록
		for (int j = 0; j < num; j++)
		{
			for (int k = 0; k < num; k++)
			{
				if (j != k)
					meet[party[i][j]][party[i][k]] = 1;
			}
		}
	}

	solve();

	cout << result;

	return 0;
}