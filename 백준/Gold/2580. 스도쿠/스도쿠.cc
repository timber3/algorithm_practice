#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int g[10][10] = { 0, };
int p = 0;
// 0의 좌표를 저장하는 벡터
vector<pair<int, int>> v;

void dfs(int cnt, int x, int y, int val)
{
	// 멈춤 조건
	if (cnt == v.size() - 1 && p == 0)
	{
		cout << endl;
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cout << g[i][j] << " ";
			}
			cout << endl;
		}
		p = 1;
		exit(0);
	}

	// val이 빈칸에 들어갈 수 있는 숫자인지 확인
	for (int i = 0; i < 9; i++)
	{
		if (g[x][i] == val)
			return;
		if (g[i][y] == val)
			return;
	}

	int xpos = (x / 3) * 3;
	int ypos = (y / 3) * 3;

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (g[xpos + i][ypos + j] == val)
				return;
		}
	}

	// 여기까지 왔으면 넣을 수 있는 숫자인거임.

	g[x][y] = val;

	int nx = v[cnt + 1].first;
	int ny = v[cnt + 1].second;

	for (int i = 1; i <= 9; i++)
	{
		dfs(cnt + 1, nx, ny, i);
		g[nx][ny] = 0;
	}
}


int main()
{
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cin >> g[i][j];

			if (g[i][j] == 0)
				v.push_back(make_pair(i, j));
		}
	}

	v.push_back(make_pair(0, 0));

	for (int i = 1; i <= 9; i++)
	{
		if ( p == 0 )
			dfs(0, v.front().first, v.front().second, i);
	}

	return 0;
}