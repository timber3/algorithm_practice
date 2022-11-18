#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int answer;
int magnet[4][8];
bool visited[4];

int xd[] = { 1, -1 };

void rotate(int num, int dir)
{
	if (dir == 1)
	{
		int temp = magnet[num][7];

		for (int i = 7; i >= 0; i--)
		{
			magnet[num][i] = magnet[num][i-1];
		}

		magnet[num][0] = temp;
	}

	if (dir == -1)
	{
		int temp = magnet[num][0];

		for (int i = 0; i <= 7; i++)
		{
			magnet[num][i] = magnet[num][i + 1];
		}

		magnet[num][7] = temp;
	}
}

void DFS(int mg_num, int direct)
{
	visited[mg_num] = true;
	// 좌우에 자석이 있는지 확인
	// 좌우에 자성이 다른 애들이 있으면 rotate로 넘어가야됨.
	if (mg_num != 0)
	{
		// 왼쪽 자석이랑 자성이 다르면
		if (magnet[mg_num - 1][2] != magnet[mg_num][6] && visited[mg_num - 1] == false)
			// 방향을 반대로 돌려버린다.
			DFS(mg_num - 1, direct * -1);

	}

	if (mg_num != 3)
	{
		// 오른쪽 자석이랑 자성이 다르면
		if (magnet[mg_num + 1][6] != magnet[mg_num][2] && visited[mg_num + 1] == false)
			// 방향을 반대로 돌려버린다.
			DFS(mg_num + 1, direct * -1);
	}

	
	if (mg_num == 0)
	{
		if (magnet[mg_num + 1][6] != magnet[mg_num][2] && visited[mg_num + 1] == false)
		{
			DFS(mg_num + 1, direct * -1);
		}
	}

	if (mg_num == 3)
	{
		if (magnet[mg_num - 1][2] != magnet[mg_num][6] && visited[mg_num - 1] == false)
		{
			DFS(mg_num - 1, direct * -1);
		}
	}

	rotate(mg_num, direct);

}

void re_visited()
{
	for (int i = 0; i < 4; i++)
		visited[i] = false;
}

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		int K;
		cin >> K;

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				cin >> magnet[i][j];
			}
		}

		for (int i = 0; i < K; i++)
		{
			int change_magnet;
			int rotation_direct;

			cin >> change_magnet >> rotation_direct;

			DFS(change_magnet - 1, rotation_direct);

			re_visited();

		}


		for (int j = 0; j < 4; j++)
		{
			answer += magnet[j][0] * pow(2, j);
		}

		cout << "#" << t + 1 << " " << answer << endl;

		answer = 0;
	}

	return 0;
}