#include <bits/stdc++.h>

using namespace std;

int n;
int result;
char Map[8][8];

void hor_find(int x, int y)
{
	bool hor = true;
	// 가로 검사기 ( 오른쪽 방향으로만 가로로 검사 하기 )
	int y_end = y + n - 1;

	for (int i = 0; i < n / 2; i++)
	{
		if (Map[x][y + i] != Map[x][y_end-i])
		{
			hor = false;
			break;
		}
	}

	if (hor == true)
		result++;
}

void ver_find(int x, int y)
{
	bool ver = true;

	int x_end = x + n - 1;

	// 세로 검사
	for (int i = 0; i < n / 2; i++)
	{
		if (Map[x + i][y] != Map[x_end - i][y])
		{
			ver = false;
			break;
		}
	}

	if (ver == true)
		result++;
}


int main()
{
	for (int t = 0; t < 10; t++)
	{
		cin >> n;

		for (int i = 0; i < 8; i++)
		{
			string str;
			cin >> str;

			for (int j = 0; j < 8; j++)
			{
				Map[i][j] = str[j];
			}
		}

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j <= 8 - n; j++)
			{
				hor_find(i, j);
			}
		}

		for (int i = 0; i <= 8 - n; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				ver_find(i, j);
			}
		}

		cout << "#" << t + 1 << " " << result << '\n';

		result = 0;
	}

	return 0;
}