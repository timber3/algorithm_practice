#include <bits/stdc++.h>

using namespace std;
//int Map[11][11];
int n;
int result;

// 가로, 왼쪽 위에서 오른쪽 밑, 왼쪽밑에서 오른쪽 위, 세로
int row1[20];
int row2[20];
int row3[20];
int row4[20];

void dfs(int cnt, int x, int y)
{
	if (cnt == n)
	{
		result++;
		return;
	}

	for (int i = x; i < n; i++)
	{
		for (int j = y; j < n; j++)
		{
			if (row1[i] == 0 && row2[n - j + i] == 0 && row3[i + j + 1] == 0 && row4[j] == 0)
			{
				row1[i] = 1;
				row2[n - j + i] = 1;
				row3[i + j + 1] = 1;
				row4[j] = 1;

				dfs(cnt + 1, i, j);

				row1[i] = 0;
				row2[n - j + i] = 0;
				row3[i + j + 1] = 0;
				row4[j] = 0;
			}
			x = 0;
			y = 0;
		}
	}
}

int main()
{
	int t;

	cin >> t;

	for (int T = 0; T < t ; T++)
	{
		cin >> n;

		dfs(0, 0, 0);

		cout << "#" << T + 1 << " " << result << '\n';

		//for (int i = 0; i < n; i++)
		//{
		//	for (int j = 0; j < n; j++)
		//	{
		//		Map[i][j] = 0;
		//	}
		//}

		fill(row1, row1 + 20, 0);
		fill(row2, row2 + 20, 0);
		fill(row3, row3 + 20, 0);
		fill(row4, row4 + 20, 0);

		result = 0;

	}

	return 0;
}

// n크기의 판을 설정하면 왼쪽 위에서 오른쪽 아래로 가는 2*n - 1개의 대각선 줄이 생긴다.
// 반대 방향도 마찬가지 이므로 2*n - 1개
// 한 대각선에 들어와있으면 이 대각선은 사용 불가
// 대각선 뿐만 아니라 가로선이나 세로선도 생각 해야함.
// 같은 행, 열에 존재하면 안되면서 같은 대각선 상에도 있으면 안됨.