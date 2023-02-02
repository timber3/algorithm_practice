#include <bits/stdc++.h>
using namespace std;
int n, m, K;
int MAP[11][11];
int eat[11][11];
deque<int> tree[11][11];
vector<int> dead_tree[11][11];
int dx[8] = { -1,-1,-1,0,0,1,1,1 };
int dy[8] = { -1,0,1,-1,1,-1,0,1 };
void spring() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int size = tree[i][j].size();
			while (size--) {
				int age = tree[i][j].front();
				tree[i][j].pop_front();
				if (MAP[i][j] < age) {
					dead_tree[i][j].push_back(age);
					continue;
				}
				MAP[i][j] -= age;
				tree[i][j].push_back(age + 1);
			}
		}
	}
}

void summer() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int size = dead_tree[i][j].size();
			while (size--) {
				int age = dead_tree[i][j].back();
				dead_tree[i][j].pop_back();
				MAP[i][j] += (age / 2);

			}
		}
	}
}

void fall() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			for (int k = 0; k < tree[i][j].size(); k++) {
				int age = tree[i][j][k];
				if (age % 5 == 0) {
					for (int dir = 0; dir < 8; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
						tree[nx][ny].push_front(1);
					}
				}
			}
		}
	}
}

void winter() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			MAP[i][j] += eat[i][j];
		}
	}
}

void count_tree() {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			sum += tree[i][j].size();
		}
	}
	cout << sum;
}
void INPUT() {
	cin >> n >> m >> K;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			MAP[i][j] = 5;
			cin >> eat[i][j];
		}
	}

	for (int i = 0; i < m; i++) {
		int x, y, z;
		cin >> x >> y >> z;
		tree[x][y].push_back(z);
	}
}

void solve() {
	while (K--) {
		spring();
		summer();
		fall();
		winter();
	}
	count_tree();
}
void solution() {
	INPUT();
	solve();
}
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	solution();
	return 0;
}