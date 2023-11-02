
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int n, m, ans;
	static int[][] map, tempMap;
	static boolean[][] visited;
	static boolean flag;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simul();
		
		if (!flag)
			System.out.print(0);

	}

	static void simul() {

		while(check()) {

			tempMap = new int[n][m];

			// 빼야 할 값을 계산 해준다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {

					if (map[i][j] > 0) {
						int cx = i;
						int cy = j;

						for (int k = 0; k < 4; k++) {
							int nx = cx + dx[k];
							int ny = cy + dy[k];

							if (nx < 0 || ny < 0 || nx >= n || ny >= m)
								continue;

							if (map[nx][ny] > 0)
								continue;

							tempMap[cx][cy]++;

						}
					}

				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] -= tempMap[i][j];
				}
			}

			visited = new boolean[n][m];
			int cnt = 0;
			ans += 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						cnt += 1;
						bfs(i, j);
					}
				}
			}

			if (cnt >= 2) {
				System.out.print(ans);
				flag = true;
				return;
			}
		}
	}

	static void bfs(int i, int j) {

		Queue<Node> q = new LinkedList<>();

		visited[i][j] = true;
		q.add(new Node(i, j));

		while (!q.isEmpty()) {

			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (map[nx][ny] <= 0 || visited[nx][ny])
					continue;

				q.add(new Node(nx, ny));
				visited[nx][ny] = true;

			}
		}
	}
	
	static boolean check() {
		for (int i = 0 ; i < n ; i ++ ) {
			for (int j = 0 ; j < m ; j ++) {
				if (map[i][j] > 0)
					return true;
			}
		}
		
		return false;
	}
}
