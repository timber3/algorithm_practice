#include <iostream>
#include <algorithm>
#include <utility>
#include <queue>
using namespace std;

int dx[12] = { 1,0,-1,0,2,2,1,1,-1,-1,-2,-2 };
int dy[12] = { 0,1,0,-1,-1,1,-2,2,-2,2,-1,1 };
int dist[201][201][31] = { 0, };
int board[201][201];

struct xyz {
	int x, y, z;
};

queue<xyz> q;
int K, W, H;

//말처럼 이동하는 걸 어떻게 할 것인가?
//단순 BFS로 풀 수 있는 문제인가?
//DFS로는 안되나? -> 최단거리이기에 안됨
//움직임의 순서는 어떻게 해야되나?
//K번 움직이는 걸 어떻게?

int bfs() {
	q.push({ 0,0 ,0});
	dist[0][0][0] = 0;
	while (!q.empty()) {
		xyz cur = q.front();
		int x = cur.x;
		int y = cur.y;
		int z = cur.z;
		if (x == H - 1 && y == W - 1) {
			return dist[x][y][z];
		}
		q.pop();
		for (int i = 0; i < 12; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z;
			
			if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
			if (dist[nx][ny][nz]) continue;
			if (board[nx][ny] == 1) continue;
			if (i >= 4) {
				if (dist[nx][ny][nz + 1]) continue;
				if (nz >= K) continue;
				dist[nx][ny][nz + 1] = dist[x][y][z] + 1;
				q.push({ nx,ny,nz + 1 });
			}
			else {
				dist[nx][ny][nz] = dist[x][y][z] + 1;
				q.push({ nx,ny,nz });
			}
			
		}
	}

	
	return -1;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> K >> W >> H;

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			cin >> board[i][j];
		}
	}
	cout << bfs() << "\n";

}