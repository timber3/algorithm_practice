#include <bits/stdc++.h>

using namespace std;

// 판 넓이
int n;
// 경사로의 길이
int l;
int Map[100][100] = { 0, };
int sum = 0;
int visited[100][100] = { 0, };
bool flag = true;
// 경사로의 높이는 1, 길이는 L
// 경사로를 놓은곳에는 또 놓을 수 없음.
// 높이차이가 1일 경우에만 가능.
// 경사로가 Map 범위를 넘어가는 경우.

void solve()
{
	// 가로줄 확인하기
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n - 1; j++)
		{
			flag = true;
			int dif = abs(Map[i][j] - Map[i][j + 1]);
			// i,j 와 i,j+1의 차이가 2이상일 경우 무조건 불가능함.
			if (dif >= 2)
			{
				flag = false;
				break;
			}
			// 옆칸과 차이가 1일 때
			else if (dif == 1)
			{
				// 높아지는 경우일 때
				if (Map[i][j] < Map[i][j + 1])
				{
					// 여유가 있어야 경사로를 배치할 수 있음.
					if (j >= (l - 1))
					{
						// for문을 무사히 통과하면 경사로 배치
						for (int k = j; k > j - l; k --)
						{
							if (Map[i][j] != Map[i][k] || visited[i][k])
							{
								flag = false;
								break;
							}
						}

						if (flag == false)
							break;

						for (int k = j; k > j - l; k--)
						{
							visited[i][k] = 1;
						}
					}
					else
					{
						flag = false;
						break;
					}
				}
				// 낮아지는 경우일 때
				if (Map[i][j] > Map[i][j + 1])
				{
					if (n - j > l)
					{
						for (int k = j+1; k <= j + l; k++)
						{
							if (Map[i][j+1] != Map[i][k] || visited[i][k])
							{
								flag = false;
								break;
							}
						}
						if (flag == false)
							break;

						for (int k = j + 1; k <= j + l; k++)
						{
							visited[i][k] = 1;
						}
					}
					else
					{
						flag = false;
						break;
					}
				}
			}
			// 평평할 때
			else if( dif == 0 )
			{
				continue;
			}
		}
		if (flag == true)
			sum++;
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			visited[i][j] = 0;
		}
	}

	// 세로줄 확인하기
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n - 1; j++)
		{
			flag = true;
			int dif = abs(Map[j][i] - Map[j+1][i]);
			// j,i 와 j+1,i의 차이가 2이상일 경우 무조건 불가능함.
			if (dif >= 2)
			{
				flag = false;
				break;

			}
			// 옆칸과 차이가 1일 때
			else if (dif == 1)
			{
				// 높아지는 경우일 때
				if (Map[j][i] < Map[j+1][i])
				{
					// 여유가 있어야 경사로를 배치할 수 있음.
					if (j >= (l - 1))
					{
						for (int k = j; k > j - l; k--)
						{
							if (Map[j][i] != Map[k][i] || visited[k][i])
							{
								flag = false;
								break;
							}
						}
						if (flag == false)
							break;
						for (int k = j; k > j - l; k--)
						{
							visited[k][i] = 1;
						}
					}
					else
					{
						flag = false;
						break;
					}
				}
				// 낮아지는 경우일 때
				if (Map[j][i] > Map[j+1][i])
				{
					if (n - j > l)
					{
						for (int k = j + 1; k <= j + l; k++)
						{
							if (Map[j+1][i] != Map[k][i] || visited[k][i])
							{
								flag = false;
								break;
							}
						}
						if (flag == false)
							break;
						for (int k = j + 1; k <= j + l; k++)
						{
							visited[k][i] = 1;
						}

					}
					else
					{
						flag = false;
						break;
					}
				}
			}
			// 평평할 때
			else if (dif == 0)
			{
				continue;
			}
		}
		if (flag == true)
			sum++;
	}

}
int main()
{
	cin >> n >> l;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cin >> Map[i][j];
	}

	solve();
	cout << sum;
	return 0;
}