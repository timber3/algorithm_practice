#include <bits/stdc++.h>

using namespace std;

typedef struct node {
	int x;
	int y;
};

int n, m, g, r;
int Max = 0;

// 사용할 순열 구하기용
int used[10];
int Map[51][51];
pair<int, int> state[51][51]; // 색깔, 시간

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

vector<node> y;
queue<node> q;

void bfs()
{
	for (int i = 0; i < n; i++)
	{
		fill(state[i], state[i] + m, make_pair(0,-1));
	}

	// q에 값 넣기 ( used에 사용할 그거 나와있음 )
	for (int i = 0; i < y.size(); i++)
	{
		// green
		if (used[i] == 1)
		{
			state[y[i].x][y[i].y] = { 1,0 };
			q.push({ y[i].x, y[i].y });
		}
		else if (used[i] == 2)
		{
			state[y[i].x][y[i].y] = { 2,0 };
			q.push({ y[i].x, y[i].y });
		}
	}

	int flower = 0;

	// 빨간약,초록약이 뿌려진 위치가 담긴 큐에서 BFS 돌리기
	while (!q.empty())
	{
		int cx = q.front().x;
		int cy = q.front().y;
		int ccolor = state[cx][cy].first;
		int cdep = state[cx][cy].second;

		q.pop();

		if (state[cx][cy].first == 3) continue;

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			int ndep = cdep + 1;

			// 호수거나 꽃이라면
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || Map[nx][ny] == 0 || state[nx][ny].first == 3)
				continue;

			// 아직 닿지 않은 곳이라면
			if (state[nx][ny].first == 0)
			{
				state[nx][ny].first = ccolor;
				state[nx][ny].second = ndep;
				q.push({ nx,ny });
			}
			// 꽃이 필 자리이면 (시간이 같고, 색깔이 다를 경우)
			else if (state[nx][ny].second == ndep && (state[nx][ny].first + ccolor == 3))
			{
				state[nx][ny] = make_pair(3, ndep);
				flower++;
			}
		}
	}

	Max = max(Max, flower);

	return;

}

// 하얀칸 : 배양액 못뿌림 , 황토칸 : 배양액 뿌릴수있 , 하늘색 : 호수
int main()
{
	cin >> n >> m >> g >> r;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			// 0 : 호수, 1 : 흰색칸, 2 : 황토칸
			cin >> Map[i][j];

			if (Map[i][j] == 2)
			{
				y.push_back({ i,j });
			}
		}
	}

	int blanc = y.size() - g - r;

	fill(used + blanc, used + blanc + g, 1);
	fill(used + blanc + g, used + y.size(), 2);

	do {
		bfs();
	} while (next_permutation(used, used + y.size()));

	cout << Max;

	return 0;
}