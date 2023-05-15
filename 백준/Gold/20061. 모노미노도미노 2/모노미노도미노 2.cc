#include <bits/stdc++.h>

using namespace std;

int n;
int score;
int rest_tile;
int Map[11][11];

typedef struct node {
	int x;
	int y;
};

vector<pair<int, node>> v;

void add_tile(int t, int x, int y)
{
	if (t == 1)
	{
		int b_put = 0;
		int g_put = 0;

		for (int i = 6; i < 10; i++)
		{
			if (Map[x][i] == 1)
			{
				Map[x][i - 1] = 1;
				b_put = 1;
				break;
			}
		}

		for (int i = 6; i < 10; i++)
		{
			if (Map[i][y] == 1)
			{
				Map[i - 1][y] = 1;
				g_put = 1;
				break;
			}
		}

		if (b_put == 0)
		{
			Map[x][9] = 1;
		}

		if (g_put == 0)
		{
			Map[9][y] = 1;
		}	
	}

	else if (t == 2)
	{
		int b_put = 0;
		int g_put = 0;

		for (int i = 6; i < 10; i++)
		{
			if (Map[x][i] == 1)
			{
				// 파란타일에 두기
				Map[x][i - 1] = 1;
				Map[x][i - 2] = 1;
				b_put = 1;
				break;
			}
		}
		
		for (int i = 6; i < 10; i++)
		{
			if (Map[i][y] == 1 || Map[i][y+1] == 1)
			{
				// 초록타일에 두기
				Map[i - 1][y] = 1;
				Map[i - 1][y+1] = 1;
				g_put = 1;
				break;
			}
		}

		if (b_put == 0)
		{
			Map[x][9] = 1;
			Map[x][8] = 1;
		}

		if (g_put == 0)
		{
			Map[9][y] = 1;
			Map[9][y + 1] = 1;
		}
	}

	else if (t == 3)
	{
		int b_put = 0;
		int g_put = 0;

		for (int i = 6; i < 10; i++)
		{
			if (Map[x][i] == 1 || Map[x + 1][i] == 1)
			{
				// 파란타일에 두기
				Map[x][i - 1] = 1;
				Map[x + 1][i - 1] = 1;
				b_put = 1;
				break;
			}
		}
		for (int i = 6; i < 10; i++)
		{
			if (Map[i][y] == 1)
			{
				// 초록타일에 두기
				Map[i - 1][y] = 1;
				Map[i - 2][y] = 1;
				g_put = 1;
				break;
			}
		}

		if (b_put == 0)
		{
			Map[x][9] = 1;
			Map[x+1][9] = 1;
		}

		if (g_put == 0)
		{
			Map[9][y] = 1;
			Map[8][y] = 1;
		}
	}
}

void check_point()
{
	for (int i = 9; i >= 6; i--)
	{
		// 파란줄 한줄이 점수 먹는다면
		if (Map[0][i] && Map[1][i] && Map[2][i] && Map[3][i])
		{
			for (int j = 0; j < 4; j++)
			{
				Map[j][i] = 0;
			}
			score++;

			for (int j = i - 1; j >= 4; j--)
			{
				for (int k = 0; k < 4; k++)
				{
					Map[k][j + 1] = Map[k][j];
					Map[k][j] = 0;
				}
			}

			i++;
		}
	}

	for (int i = 9; i >= 6; i--)
	{
		// 초록줄 한줄이 점수 먹는다면
		if (Map[i][0] && Map[i][1] && Map[i][2] && Map[i][3])
		{
			for (int j = 0; j < 4; j++)
			{
				Map[i][j] = 0;
			}
			score++;

			for (int j = i - 1; j >= 4; j--)
			{
				for (int k = 0; k < 4; k++)
				{
					Map[j+1][k] = Map[j][k];
					Map[j][k] = 0;
				}
			}
			i++;
		}
	}
}

void light_push()
{
	for (int i = 5; i >= 4; i--)
	{
		// 파란색 투명한 부분에 하나라도 있다면
		if (Map[0][i] || Map[1][i] || Map[2][i] || Map[3][i])
		{
			for (int j = 0; j < 4; j++)
			{
				Map[j][9] = 0;
			}

			for (int j = 8; j >= 4; j--)
			{
				for (int k = 0; k < 4; k++)
				{
					Map[k][j + 1] = Map[k][j];
					Map[k][j] = 0;
				}
			}

			i++;
		}
	}

	for (int i = 5; i >= 4; i--)
	{
		// 초록색 투명한 부분에 하나라도 있다면
		if (Map[i][0] || Map[i][1] || Map[i][2] || Map[i][3])
		{
			for (int j = 0; j < 4; j++)
			{
				Map[9][j] = 0;
			}

			for (int j = 8; j >= 4; j--)
			{
				for (int k = 0; k < 4; k++)
				{
					Map[j+1][k] = Map[j][k];
					Map[j][k] = 0;
				}
			}

			i++;
		}
	}
}


void solve()
{
	for (int i = 0; i < v.size(); i++)
	{
		int t = v[i].first;
		int x = v[i].second.x;
		int y = v[i].second.y;

		// 1. 빨간 타일위에 뒀을 때 파란색, 초록색으로 옮기는 과정
		add_tile(t, x, y);

		// 2. 점수 얻을 수 있는지 확인
		//  2.1 얻었으면 타일 지우고 밑으로 당기기
		check_point();

		// 3. 점수 계산할거 다 한 후에 투명한 부분 밀어넣기
		light_push();

	}

	// 나머지 타일 계산하기

	for (int i = 6; i <= 9; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			if (Map[j][i] == 1)
			{
				rest_tile++;
			}
			if (Map[i][j] == 1)
			{
				rest_tile++;
			}
		}
	}
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int a, b, c;

		cin >> a >> b >> c;

		v.push_back({a, node{b,c} });
	}

	solve();

	cout << score << '\n' << rest_tile;

	return 0;
}