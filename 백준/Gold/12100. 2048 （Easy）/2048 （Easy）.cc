#include <bits/stdc++.h>
#define endl "\n"
using namespace std;

/// <summary>
/// https://luv-n-interest.tistory.com/1346 참조
/// </summary>

int n;

int Max = 0;

// 백트래킹을 하기 위해 이전 과정에서 합쳐진 애가 있는지 기록하는 용도
vector<vector<int>> g;

void move(int dir)
{
	// 방향대로 숫자를 q에 넣어서 같은 숫자면 합치기 위해 선언
	queue<int> q;

	// 오른쪽
	if (dir == 0)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				if (g[i][j])
					q.push(g[i][j]);
				g[i][j] = 0;
			}

			// 여기까지가 한 줄을 q에 넣었을 때 오른쪽으로 밀꺼니까 합쳐지는걸 계산해준다.

			int idx = n - 1;

			while (!q.empty())
			{
				int num = q.front();
				q.pop();

				// 2 2 0 인 상황에서 오른쪽으로 옮기면 0 0 4 가 되어야 하는데
				// 빈칸이라면 일단 그냥 옮긴다.
				if (g[i][idx] == 0)
				{
					g[i][idx] = num;
				}
				// 빈칸이 아닌데 숫자가 같을 경우
				else if (g[i][idx] == num)
				{
					g[i][idx] = 2 * num;
					idx--;
				}
				// 빈칸이 아니고 숫자가 다를 경우
				else
				{
					idx--;
					g[i][idx] = num;
				}
			}
		}
	}
	// 왼쪽
	else if (dir == 1)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (g[i][j])
					q.push(g[i][j]);
				g[i][j] = 0;
			}

			// 여기까지가 한 줄을 q에 넣었을 때 왼쪽으로 밀꺼니까
			// 이제부터는 합쳐지는걸 계산해준다.

			int idx = 0;

			while (!q.empty())
			{
				int num = q.front();
				q.pop();

				// 0 2 2 인 상황에서 왼쪽으로 옮기면 4 0 0 이 되어야 하는데
				// 빈칸이라면 일단 그냥 옮긴다.
				if (g[i][idx] == 0)
				{
					g[i][idx] = num;
				}
				// 빈칸이 아닌데 숫자가 같을 경우
				else if (g[i][idx] == num)
				{
					g[i][idx] = 2 * num;
					idx++;
				}
				// 빈칸이 아니고 숫자가 다를 경우
				else
				{
					idx++;
					g[i][idx] = num;
				}
			}
		}
	}
	// 위쪽
	else if (dir == 2)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (g[j][i])
					q.push(g[j][i]);
				g[j][i] = 0;
			}

			// 여기까지가 한 줄을 q에 넣었을 때 오른쪽으로 밀꺼니까 합쳐지는걸 계산해준다.

			int idx = 0;

			while (!q.empty())
			{
				int num = q.front();
				q.pop();

				// 2 2 0 인 상황에서 오른쪽으로 옮기면 0 0 4 가 되어야 하는데
				// 빈칸이라면 일단 그냥 옮긴다.
				if (g[idx][i] == 0)
				{
					g[idx][i] = num;
				}
				// 빈칸이 아닌데 숫자가 같을 경우
				else if (g[idx][i] == num)
				{
					g[idx][i] = 2 * num;
					idx++;
				}
				// 빈칸이 아니고 숫자가 다를 경우
				else
				{
					idx++;
					g[idx][i] = num;
				}
			}
		}
	}
	// 아래쪽
	else if (dir == 3)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				if (g[j][i])
					q.push(g[j][i]);
				g[j][i] = 0;
			}

			// 여기까지가 한 줄을 q에 넣었을 때 오른쪽으로 밀꺼니까 합쳐지는걸 계산해준다.

			int idx = n - 1;

			while (!q.empty())
			{
				int num = q.front();
				q.pop();

				// 2 2 0 인 상황에서 오른쪽으로 옮기면 0 0 4 가 되어야 하는데
				// 빈칸이라면 일단 그냥 옮긴다.
				if (g[idx][i] == 0)
				{
					g[idx][i] = num;
				}
				// 빈칸이 아닌데 숫자가 같을 경우
				else if (g[idx][i] == num)
				{
					g[idx][i] = 2 * num;
					idx--;
				}
				// 빈칸이 아니고 숫자가 다를 경우
				else
				{
					idx--;
					g[idx][i] = num;
				}
			}
		}
	}
}

void dfs(int cnt)
{
	if (cnt == 5)
	{
		// 최대값 찾아서 리턴하기
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				Max = max(Max, g[i][j]);
			}
		}
		return;
	}

	int backup[21][21];

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			backup[i][j] = g[i][j];
		}
	}

	for (int i = 0; i < 4; i++)
	{
		// 판을 방향으로 이동
		move(i);
		dfs(cnt + 1);
		// 백트래킹
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				g[i][j] = backup[i][j];
			}
		}

	}

}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		// 판의 모든 history를 기록하기 위함
		vector<int> temp;
		g.push_back(temp);

		for (int j = 0; j < n; j++)
		{
			// 그래프가 아닌 벡터에 모든 값들은 저장함.
			// 벡터가 사실 그래프임
			int x;
			cin >> x;
			g[i].push_back(x);
		}
	}

	dfs(0);

	cout << Max;

	return 0;
}