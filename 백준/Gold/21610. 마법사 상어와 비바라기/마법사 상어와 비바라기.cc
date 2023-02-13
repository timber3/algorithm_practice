#include <bits/stdc++.h>

using namespace std;

int n, m;

int dir[101] = { 0, };
int dis[101] = { 0, };

int dx[] = {0, -1, -1, -1, 0, 1, 1, 1 };
int dy[] = {-1, -1, 0, 1, 1, 1, 0 ,-1 };

int cdx[] = { -1, -1, 1, 1 };
int cdy[] = { -1, 1, -1, 1 };

int Map[51][51] = {0, };
int visited[51][51] = { 0, };

vector<pair<int, int>> cloud_pos;
vector<pair<int, int>> water_pos;

int sum = 0;
// 구름들을 움직인다.
void move(int idx)
{
	int d = dir[idx] - 1;
	int s = dis[idx] % n;

	for (int i = 0; i < cloud_pos.size(); i++)
	{
		int cx = cloud_pos[i].first;
		int cy = cloud_pos[i].second;

		int nx = cx + (dx[d]*s);
		int ny = cy + (dy[d]*s);

		if (nx <= 0)
			nx += n;
		if (nx > n)
			nx -= n;
		if (ny <= 0)
			ny += n;
		if (ny > n)
			ny -= n;

		cloud_pos[i].first = nx;
		cloud_pos[i].second = ny;
	}
}
// 움직인 구름들에서 비를 내리게 한다.
void rain()
{
	water_pos.clear();

	for (int i = 0; i < cloud_pos.size(); i++)
	{
		int x = cloud_pos[i].first;
		int y = cloud_pos[i].second;

		Map[x][y] += 1;
		// 구름이 있던 장소를 x,y로 저장.
		visited[x][y] = 1;
		water_pos.push_back({ x, y });
	}
	// 구름 소멸
	cloud_pos.clear();
}
// 비가 내린 지역에 물복사
void water_magic()
{

	for (int i = 0; i < water_pos.size(); i++)
	{
		int cnt = 0;
		int cx = water_pos[i].first;
		int cy = water_pos[i].second;

		for (int j = 0; j < 4; j++)
		{
			int nx = cx + cdx[j];
			int ny = cy + cdy[j];

			if (nx <= 0 || ny <= 0 || nx > n || ny > n)
				continue;

			if (Map[nx][ny] >= 1)
				cnt++;
		}
		Map[cx][cy] += cnt;
	}
}
void make_cloud()
{
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (Map[i][j] >= 2)
			{
				if (!visited[i][j])
				{
					cloud_pos.push_back({ i,j });
					Map[i][j] -= 2;
				}
			}
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			visited[i][j] = 0;
	}
}
void cal_sum()
{
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			sum += Map[i][j];
		}
	}
}

void solve()
{
	for(int i = 0 ; i < m ; i ++)
	{
		// 1. 모든 구름이 di방향으로 si칸 이동한다.
		move(i);
		// 2. 구름에서 비가내려 칸의 바구니에 물을 1씩 뿌린다.
		rain();
		// 3. 구름이 사라진다.
		// 4. 2에서 물이 증가한 칸에 물복사 마법을 시전한다.
		// 대각선 방향에 물이 있는 바구니의 수만큼 해당 칸에 물의 양이 증가한다.
		water_magic();
		// 5. 물의 양이 2 이상인 모든 칸에 구름이 생기고 물이 2 줄어든다.
		// 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
		make_cloud();
	}

	cal_sum();
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			cin >> Map[i][j];
		}
	}

	for (int i = 0; i < m; i++)
	{
		cin >> dir[i] >> dis[i];
	}

	cloud_pos.push_back({ n, 1 });
	cloud_pos.push_back({ n, 2 });
	cloud_pos.push_back({ n-1, 1 });
	cloud_pos.push_back({ n-1, 2 });

	solve();

	cout << sum;

	return 0;
}