#include <iostream>


using namespace std;

int dice[4][3] = { 0, };
int map[20][20];
int order[1001];

//int xd[] = { 0, 0, 1, -1 };
//int yd[] = { 1, -1, 0, 0 };

int x, y;
int N, M;
int K;


// 주사위랑 바닥면에 값을 비교
void copy()
{
	if (map[x][y] == 0)
	{
		map[x][y] = dice[3][1];
	}
	else
	{
		dice[3][1] = map[x][y];
		map[x][y] = 0;
	}
}

int roll(int dir)
{
	if (dir == 1) // 동쪽으로 굴리기
	{
		if (y + 1 > M - 1)
		{
			return -1;
		}

		int temp = dice[1][2];
		dice[1][2] = dice[1][1]; // 1
		dice[1][1] = dice[1][0]; // 3
		dice[1][0] = dice[3][1]; // 바닥에 있던게 왼쪽으로 감 ;;;;;;;;
		dice[3][1] = temp;
		y++;
		return 1;
	}

	if (dir == 2) // 서쪽으로 굴리기
	{
		if (y - 1 < 0)
		{
			return -1;
		}

		int temp = dice[1][0];
		dice[1][0] = dice[1][1]; // 1
		dice[1][1] = dice[1][2]; // 4
		dice[1][2] = dice[3][1]; // 3
		dice[3][1] = temp;
		y--;
		return 1;
	}

	if (dir == 3) // 북쪽으로 굴리기
	{
		if (x - 1 < 0)
		{
			return -1;
		}

		int temp = dice[0][1];
		dice[0][1] = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = temp;
		x--;
		return 1;
	}

	if (dir == 4) // 남쪽으로 굴리기
	{
		if (x + 1 > N - 1)
		{
			return -1;
		}

		int temp = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = temp;
		x++;
		return 1;
	}
}

void input()
{
	cin >> N >> M >> x >> y >> K;
	// 세로, 가로, 시작x, 시작y, 굴릴 횟수

	// map
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> map[i][j];
		}
	}

	// order
	for (int i = 0; i < K; i++)
	{
		cin >> order[i];
	}
}

void solve()
{
	input();

	for (int i = 0; i < K; i++)
	{
		int avail = roll(order[i]);
		if (avail < 0)
		{
			continue;
		}
		copy();

		cout << dice[1][1] << endl;
	}

}


int main()
{
	solve();
	return 0;
}