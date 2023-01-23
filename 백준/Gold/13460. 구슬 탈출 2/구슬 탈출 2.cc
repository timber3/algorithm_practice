#include <bits/stdc++.h>

using namespace std;


// 파랑과 빨강은 동시에 같은 칸에 있을 수 없다.
// 기울이는걸 그만하는 것은 더이상 구슬이 움직이지 않을 때 까지
// 최소 몇번만에 빨간 구슬을 빼낼 수 있을까?
// 구슬이 가다가 구멍을 만나면 빠짐

// .:빈칸  #:벽  O:구멍  R:빨간 구슬  B:파란 구슬


int n, m;
int crx, cry, cbx, cby; // red xy, blue xy, hole xy

typedef struct BackTracking
{
	int rx, ry;
	int bx, by;
	int sum;
}bt;

int visited[10][10][10][10] = { 0, };
string Map[10][10];
queue<bt> q;

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void move(int& x, int& y, int& c, int i)
{
	// 다음 갈 곳이 벽이거나 현재 구슬이 O 에 와있으면 멈춤
	while (Map[x + dx[i]][y + dy[i]] != "#" && Map[x][y] != "O")
	{
		x += dx[i];
		y += dy[i];
		c += 1;
	}
}

void bfs()
{
	while (!q.empty())
	{
		int rx = q.front().rx;
		int ry = q.front().ry;
		int bx = q.front().bx;
		int by = q.front().by;
		int sum = q.front().sum;
		q.pop();

		if (sum >= 10) break;

		for (int i = 0; i < 4; i++)
		{
			int nrx = rx, nry = ry;
			int nbx = bx, nby = by;
			// c 는 구슬을 움직였을때의 카운트 (더 많이 움직인 구슬을 뒤로 한칸 빼줌 - 중복 처리)
			int rc = 0, bc = 0, nsum = sum + 1;

			move(nrx, nry, rc, i);
			move(nbx, nby, bc, i);

			// 파란 구슬이 O 에 들어갔으면 실패
			if (Map[nbx][nby] == "O") continue;
			if (Map[nrx][nry] == "O")
			{
				cout << nsum;
				return;
			}

			// 구슬이 겹칠 때 더 많이 움직인 구슬을 한칸 뒤로 당기기
			if (nrx == nbx && nry == nby)
			{
				if (rc < bc)
				{
					nbx -= dx[i];
					nby -= dy[i];
				}
				else
				{
					nrx -= dx[i];
					nry -= dy[i];
				}
			}

			if (visited[nrx][nry][nbx][nby]) continue;
			visited[nrx][nry][nbx][nby] = 1;
			q.push({ nrx, nry, nbx, nby, nsum });
		}

	}

	cout << -1;
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		string t;
		cin >> t;

		for (int j = 0; j < m; j++)
		{
			if (t[j] == 'R')
			{
				crx = i;
				cry = j;
			}
			else if (t[j] == 'B')
			{
				cbx = i;
				cby = j;
			}
			Map[i][j] = t[j];
		}
	}

	q.push({ crx, cry, cbx, cby, 0 });
	visited[crx][cry][cbx][cby] = 1;
	bfs();

	return 0;
}