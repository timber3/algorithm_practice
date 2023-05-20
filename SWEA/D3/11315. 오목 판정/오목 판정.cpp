#include <bits/stdc++.h>

using namespace std;

int n;
char Map[21][21];

int dx[] = { 0,0,1,-1,1,1,-1,-1 };
int dy[] = { 1,-1,0,0,1,-1,1,-1 };

bool solve(int x, int y)
{
	int cx = x;
	int cy = y;

	for (int i = 0; i < 8; i++)
	{
		bool omok = true;

		int nx = cx + dx[i];
		int ny = cy + dy[i];

		if (nx < 0 || ny < 0 || nx >= n || ny >= n || Map[nx][ny] == '.')
			continue;

		else
		{
			for (int j = 0; j < 3; j++)
			{
				nx = nx + dx[i];
				ny = ny + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || Map[nx][ny] == '.')
				{
					omok = false;
					break;
				}
			}

			if (omok == true)
				return true;
		}
	}

	return false;
}

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		bool create_omok = false;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			string str;

			cin >> str;

			for (int j = 0; j < str.size(); j++)
			{
				Map[i][j] = str[j];
			}
		}


		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (Map[i][j] == 'o')
				{
					create_omok = solve(i, j);
				}

				if (create_omok)
					break;
			}
			if (create_omok)
				break;
		}

		if (create_omok)
			cout << "#" << t+1 << " " << "YES" << '\n';
		else
			cout << "#" << t+1 <<  " " << "NO" << '\n';

	}

	return 0;
}