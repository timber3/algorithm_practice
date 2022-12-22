#include <bits/stdc++.h>

#define endl "\n"

using namespace std;

int n, m;

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

char g[21][21];

// 동전의 각 위치

int fxpos1 = -1;
int fypos1 = -1;
int fxpos2 = -1;
int fypos2 = -1;
int drop1 = 0;
int drop2 = 0;
int Min = 100;

void dfs(int cnt, int xpos1, int ypos1, int xpos2, int ypos2)

{
	if (cnt > 10)
		return;

	drop1 = 0;
	drop2 = 0;

	// 첫번째 동전이 떨어졌는지
	if (xpos1 < 0 || ypos1 < 0 || xpos1 >= n || ypos1 >= m)
	{
		drop1 = 1;
	}
	// 두번째 동전이 떨어졌는지
	if (xpos2 < 0 || ypos2 < 0 || xpos2 >= n || ypos2 >= m)
	{
		drop2 = 1;
	}
	// 둘 중 하나만 떨어졌다면
	if (drop1 + drop2 >= 1)
	{
		if (drop1 + drop2 == 1)
		{
			if (Min > cnt)
			{
				Min = cnt;
			}
			return;
		}
		else
		{
			return;
		}
	}

	int nx1, ny1, nx2, ny2;


	for (int i = 0; i < 4; i++)
	{
		nx1 = xpos1 + dx[i];
		ny1 = ypos1 + dy[i];
		nx2 = xpos2 + dx[i];
		ny2 = ypos2 + dy[i];

		int firstavail = 1;
		int secondavail = 1;

		if (g[nx1][ny1] == '#')
		{
			nx1 = xpos1;
			ny1 = ypos1;
			firstavail = 0;

		}
		if (g[nx2][ny2] == '#')
		{
			nx2 = xpos2;
			ny2 = ypos2;
			secondavail = 0;
		}
		
		if( firstavail || secondavail )
			dfs(cnt + 1, nx1, ny1, nx2, ny2);
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> g[i][j];

			if (g[i][j] == 'o')
			{
				if (fxpos1 == -1 && fypos1 == -1)
				{
					fxpos1 = i;
					fypos1 = j;
				}
				else
				{
					fxpos2 = i;
					fypos2 = j;
				}

			}
		}
	}

	dfs(0, fxpos1, fypos1, fxpos2, fypos2);

	if (Min > 10)
	{
		cout << "-1";
	}
	else
	{
		cout << Min;
	}

	return 0;
}
