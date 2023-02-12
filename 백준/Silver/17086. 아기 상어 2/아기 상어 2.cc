#include <bits/stdc++.h>

#define INF 987654321

using namespace std;

int arr[51][51];
int dy[8][2] = { {-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{-1,1},{1,-1} };
bool ch[51][51];
int N, M;

struct info {
	int x, y, cnt;
	info(int a, int b, int c) {
		x = a;
		y = b;
		cnt = c;
	}
};

int bfs(int x, int y) {
	memset(ch, false, sizeof(ch));
	ch[x][y] = true;
	queue<info> q;
	q.push(info(x, y, 0));
	while (!q.empty()) {
		x = q.front().x;
		y = q.front().y;
		int cnt = q.front().cnt;
		q.pop();
		if (arr[x][y] == 1) return cnt;
		for (int k = 0; k < 8; k++) {
			int nx = x + dy[k][0];
			int ny = y + dy[k][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || ch[nx][ny]) continue;
			ch[nx][ny] = true;
			q.push(info(nx, ny, cnt + 1));
		}
	}
	return INF;
}

int main() {
	
	cin >> N >> M;
	vector<pair<int,int>> xy;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 0) xy.push_back({ i,j });
		}
	}
	int res = -1;
	for (int i = 0; i < xy.size(); i++) {
		int x = xy[i].first;
		int y = xy[i].second;

		int n = bfs(x, y);
		res = max(res, n);
	}
	cout << res << "\n";
	return 0;
}