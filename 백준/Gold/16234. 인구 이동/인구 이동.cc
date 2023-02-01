#include <bits/stdc++.h>

using namespace std;

int n, l, r;

int Map[51][51] = { 0, };
int visited[51][51] = { 0, };

int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1, 0, 0 };

int sum = 0;
int day = 0;
int flag = 1;

queue<pair<int, int>> trade;
vector<pair<int, int>> area;

void bfs(int x, int y)
{
	// 처음에 들어온 값을 넣어준다.
	trade.push(area[0]);
	visited[x][y] = 1;

	while (!trade.empty())
	{
		// q에 들어온 값은 빼면서 합계에 넣어줌.
		pair<int, int> temp = trade.front();
		sum += Map[temp.first][temp.second];
		trade.pop();

		for (int t = 0; t < 4; t++)
		{
			int cx = temp.first;
			int cy = temp.second;

			int nx = temp.first + dx[t];
			int ny = temp.second + dy[t];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == 1)
				continue;
			else
			{
				int dif = abs(Map[cx][cy] - Map[nx][ny]);
				// 두 도시의 인구수 차이가 L이상 R이하면
				if (dif >= l && dif <= r)
				{
					visited[nx][ny] = 1;
					area.push_back(make_pair(nx, ny));
					trade.push(make_pair(nx, ny));
				}
			}
		}
	}
}

int main()
{
	cin >> n >> l >> r;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> Map[i][j];
		}
	}

	while (flag)
	{
		flag = 0;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
				visited[i][j] = 0;
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (!visited[i][j])
				{
					area.clear();
					sum = 0;
					area.push_back(make_pair(i, j));
					bfs(i, j);

					// 연합이 생겼다는 뜻이므로 평균 값 넣어주고 day++
					if (area.size() >= 2)
					{
						flag = 1;
						for (int t = 0; t < area.size(); t++)
						{
							Map[area[t].first][area[t].second] = sum / area.size();
						}
					}
				}

			}
		}

		if (flag == 1)
			day++;
	}

	cout << day;

	return 0;
}