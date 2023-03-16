#include <bits/stdc++.h>

using namespace std;

int Map[26][26];
int visited[26][26];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
int n;

typedef struct node {
	int x;
	int y;
};

queue<node> q;
vector<int> v;

int bfs(int i, int j)
{
	int val = 0;

	q.push({ i,j });
	visited[i][j] = 1;

	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;

		val++;

		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || !Map[nx][ny] )
				continue;

			else
			{
				q.push({ nx,ny });
				visited[nx][ny] = 1;
			}
		}
	}

	return val;
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < str.size(); j++)
			Map[i][j] = str[j] - '0';
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (Map[i][j] && !visited[i][j])
			{
				int result = bfs(i, j);
				v.push_back(result);
			}
		}
	}

	sort(v.begin(), v.end());

	cout << v.size() << "\n";

	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << "\n";
	}

	return 0;
}