#include <bits/stdc++.h>
using namespace std;
int n, m, t, x, d, K;
int MAP[51][51];
int TEMP[51][51];
int ans;
void setting() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			TEMP[i][j] = MAP[i][j];
		}
	}
}

void setting1() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			MAP[i][j] = TEMP[i][j];
		}
	}
}

void move(int x, int d, int K) {
	cin >> x >> d >> K;

	for (int i = 1; i <= n; i++) {
		if (i % x == 0) {
			if (d == 0) {
				for (int j = 0; j < K; j++) {
					int tmp = MAP[i][m];
					for (int k = m; k >= 2; k--) {
						MAP[i][k] = MAP[i][k - 1];
					}
					MAP[i][1] = tmp;
				}
			}
			else if (d == 1) {
				for (int j = 0; j < K; j++) {
					int tmp = MAP[i][1];
					for (int k = 1; k <= m - 1; k++) {
						MAP[i][k] = MAP[i][k + 1];
					}
					MAP[i][m] = tmp;
				}
			}
		}
	}
}

bool remove() {
	bool flag = false;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (TEMP[i][j] == 0) continue;
			if (i == 1) {
				int idx1 = j - 1;
				int idx2 = j + 1;
				if (idx1 == 0) idx1 = m;
				if (idx2 == m + 1) idx2 = 1;
				if (MAP[i][j] == MAP[i][idx1]) {
					TEMP[i][j] = 0;
					TEMP[i][idx1] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i][idx2]) {
					TEMP[i][j] = 0;
					TEMP[i][idx2] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i + 1][j]) {
					TEMP[i][j] = 0;
					TEMP[i + 1][j] = 0;
					flag = true;
				}
			}
			else if (i == n) {
				int idx1 = j - 1;
				int idx2 = j + 1;
				if (idx1 == 0) idx1 = m;
				if (idx2 == m + 1) idx2 = 1;
				if (MAP[i][j] == MAP[i][idx1]) {
					TEMP[i][j] = 0;
					TEMP[i][idx1] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i][idx2]) {
					TEMP[i][j] = 0;
					TEMP[i][idx2] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i - 1][j]) {
					TEMP[i][j] = 0;
					TEMP[i - 1][j] = 0;
					flag = true;
				}
			}
			else {
				int idx1 = j - 1;
				int idx2 = j + 1;
				if (idx1 == 0) idx1 = m;
				if (idx2 == m + 1) idx2 = 1;
				if (MAP[i][j] == MAP[i][idx1]) {
					TEMP[i][j] = 0;
					TEMP[i][idx1] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i][idx2]) {
					TEMP[i][j] = 0;
					TEMP[i][idx2] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i + 1][j]) {
					TEMP[i][j] = 0;
					TEMP[i + 1][j] = 0;
					flag = true;
				}
				else if (MAP[i][j] == MAP[i - 1][j]) {
					TEMP[i][j] = 0;
					TEMP[i - 1][j] = 0;
					flag = true;
				}
			}
		}
	}

	if (flag) return true;
	else return false;
}

void solve() {
	int cnt = 0;
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (TEMP[i][j] != 0) {
				sum += TEMP[i][j];
				cnt++;
			}
		}
	}
	double avg = (double)sum / cnt;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (TEMP[i][j] > avg) {
				TEMP[i][j]--;
			}
			else if (TEMP[i][j] < avg && TEMP[i][j] > 0) {
				TEMP[i][j]++;
			}
		}
	}

}

void answer_count() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (MAP[i][j] != 0) {
				ans += MAP[i][j];
			}
		}
	}
	cout << ans;
}
void INPUT() {
	cin >> n >> m >> t;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> MAP[i][j];
		}
	}
}
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	INPUT();
	for (int i = 0; i < t; i++) {
		move(x, d, K);
		setting();
		if (!remove()) solve();
		setting1();
	}
	answer_count();
	
	return 0;
}