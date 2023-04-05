#include <bits/stdc++.h>

using namespace std;

char Map[5][5];
int visited[5][5];
int checked[5][5];
int ix, iy;

int result;

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

typedef struct node{
	int x;
	int y;
}node;

queue<node> q;


void dfs(int x, int y, int cnt)
{
 	if (cnt == 7)
	{
		for (int i = 0; i < 5; i++)
			fill(checked[i], checked[i] + 5, 0);

		int dasom = 0;
		int sum = 0;
		q.push(node{ ix, iy });
		checked[ix][iy] = 1;

		// 2. 다솜파가 많은지, 인접한지 확인한다.
		while (!q.empty())
		{
			int cx = q.front().x;
			int cy = q.front().y;

			if (Map[cx][cy] == 'S')
				dasom++;

			q.pop();

			for (int i = 0; i < 4; i++)
			{
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || checked[nx][ny])
					continue;

				if (visited[nx][ny])
				{
					checked[nx][ny] = 1;
					q.push(node{ nx,ny });
					sum++;
				}
			}
		}

		if (sum == 6 && dasom >= 4)
			result++;

		return;
	}

	// 1. 일단 가능한 조합을 구한다.
	for (int i = x; i < 5; i++)
	{
		for (int j = y; j < 5; j++)
		{
			y = 0;
			if (!visited[i][j])
			{
				visited[i][j] = 1;
				ix = i;
				iy = j;
				dfs(i, j, cnt + 1);
				visited[i][j] = 0;
			}
		}
	}


}

// 칠공주 중에서 무조건 이다솜파는 4명 이상이어야 한다.
int main()
{
	for (int i = 0; i < 5; i++)
	{
		string str;
		cin >> str;

		for (int j = 0; j < 5; j++)
		{
			Map[i][j] = str[j];
		}
	}

	dfs(0,0,0);

	cout << result;

	return 0;
}