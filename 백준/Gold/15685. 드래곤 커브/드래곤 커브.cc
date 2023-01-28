#include<iostream>
#include<vector>
#define SIZE 101

using namespace std;

int dx[4] = {0,-1,0,1};
int dy[4] = {1,0,-1,0};
vector<int> dir;
bool visit[SIZE][SIZE];
void init() {
	for (int a = 0; a < SIZE; a++) {
		for (int b = 0; b < SIZE; b++) {
			visit[a][b] = false;
		}
	}
}
int checkResult() {
	int ans = 0;
	for (int a = 0; a < SIZE-1; a++) {
		for (int b = 0; b < SIZE-1; b++) {
			if (visit[a][b] && visit[a][b + 1] && visit[a + 1][b] && visit[a + 1][b + 1]) {
				ans++;
			}
		}
	}
	return ans;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t, x, y, d, g;
	cin >> t;
	init();
	for (int a = 0; a < t; a++) {
		dir.clear();
		cin >> y >> x >> d >> g;

		visit[x][y] = true;
		dir.push_back(d);

		for (int a = 0; a < g; a++) {
			//미리 vector의 사이즈를 받아서 반복문 시작해야한다.
			int index = dir.size() - 1;
			for (int b = index; b >= 0; b--) {
				int td = dir[b];
				td += 1;
				if (td == 4) td = 0;
				dir.push_back(td);
			}
		}
		for (int a = 0; a < dir.size(); a++) {
			x = x + dx[dir[a]];
			y = y + dy[dir[a]];
			//배열의 범위를 벗어나지 않아야한다.
			if (x >= 0 && y >= 0 && x < SIZE && y < SIZE) {
				visit[x][y] = true;
			}
		}
	}
	cout << checkResult();
}