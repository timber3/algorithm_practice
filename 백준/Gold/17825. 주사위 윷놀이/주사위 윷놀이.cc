#include <bits/stdc++.h>

using namespace std;

int Max = 0;
int mv[10];
int Map[33];
int turn[33];
int score[33];
int check[33];
int mal[4];

void dfs(int cnt, int sum)
{
	if (cnt == 10)
	{
		if (sum > Max)
			Max = sum;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int prev = mal[i];
		int now = prev;
		int move = mv[cnt];

		// 현재 위치가 방향 전환 해야하는 곳이면
		if (turn[now] > 0)
		{
			now = turn[now];
			move -= 1;
		}

		while (move--)
		{
			now = Map[now];
		}

		if (now != 21 && check[now] == 1)
			continue;

		check[prev] = 0;
		check[now] = 1;
		mal[i] = now;

		dfs(cnt + 1, sum + score[now]);

		check[prev] = 1;
		check[now] = 0;
		mal[i] = prev;

	}

}

int main()
{
	for (int i = 0; i < 10; i++)
	{
		cin >> mv[i];
	}

	for (int i = 0; i < 27; i++)
	{
		if (i == 21)
			continue;
		Map[i] = i + 1;
	}

	Map[21] = 21;
	Map[27] = 20;
	Map[28] = 29; Map[29] = 30; Map[30] = 25; Map[31] = 32; Map[32] = 25;

	turn[5] = 22; turn[10] = 31; turn[15] = 28; turn[25] = 26;

	for (int i = 0; i < 21; i++)
	{
		score[i] = i * 2;
	}
	score[22] = 13; score[23] = 16; score[24] = 19;
	score[31] = 22; score[32] = 24; score[28] = 28;
	score[29] = 27; score[30] = 26; score[25] = 25;
	score[26] = 30; score[27] = 35;
	dfs(0, 0);

	cout << Max;

	return 0;
}