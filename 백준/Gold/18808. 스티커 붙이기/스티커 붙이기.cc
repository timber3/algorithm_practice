#include <bits/stdc++.h>

using namespace std;

// 세로, 가로, 스티커 개수
int n, m, k;
int Map[41][41];
int sticker[11][11];
int r, c;

void rolling()
{
	int roll[11][11];

	for (int i = 0; i < c; i++)
	{
		for (int j = 0; j < r; j++)
		{
			roll[i][j] = sticker[r - j - 1][i];
		}
	}

	for (int i = 0; i < r; i++)
	{
		fill(sticker[i], sticker[i] + c, 0);
	}
	
	swap(r, c);

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			sticker[i][j] = roll[i][j];
		}
	}
}

bool pastable(int x, int y)
{
	// 붙일 수 있는지 확인
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (Map[x + i][y + j] == 1 && sticker[i][j] == 1)
				return false;
		}
	}

	// false 가 안나왔다면 그자리에서 붙이기
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (sticker[i][j] == 1)
				Map[x + i][y + j] = 1;
		}
	}
	return true;
}

int main()
{
	cin >> n >> m >> k;

	for (int i = 0; i < k; i++)
	{
		cin >> r >> c;

		for (int j = 0; j < r; j++)
		{
			for (int t = 0; t < c; t++)
			{
				cin >> sticker[j][t];
			}
		}

		for (int rot = 0; rot < 4; rot++)
		{
			bool is_paste = false;

			for (int x = 0; x <= n - r; x++)
			{
				if (is_paste)
					break;
				for (int y = 0; y <= m - c; y++)
				{
					if (pastable(x, y))
					{
						is_paste = true;
						break;
					}
				}
			}
			if (is_paste)
				break;

			rolling();
		}
	}

	int cnt = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cnt += Map[i][j];
		}
	}

	cout << cnt;
	
	return 0;
}