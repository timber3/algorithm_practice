import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int x;
		int y;
		int d;
		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static int n, m, rx, ry, rd, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		rx = Integer.parseInt(st.nextToken());
		ry = Integer.parseInt(st.nextToken());
		rd = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 벽은 청소가 되어있다고 하고 감
				if(map[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		
		solve();
		
		System.out.println(result);
	}
	
	static void solve() {
		while(true) {
			// 1번 시작
			// 청소가 안되어 있다면 청소해주고 결과에 더해주기
			if (!visited[rx][ry]) {
				visited[rx][ry] = true;
				result ++;
			}
			
			// 만약 현재위치 기준 주변이 모두 청소 되어있어서 갈 곳이 없으면
			if (visited[rx+dx[0]][ry+dy[0]] && visited[rx+dx[1]][ry+dy[1]]
					&& visited[rx+dx[2]][ry+dy[2]] && visited[rx+dx[3]][ry+dy[3]]) {
				// 후진할 수 있다면
				if (inRange(rx-dx[rd], ry-dy[rd]) && map[rx-dx[rd]][ry-dy[rd]] == 0) {
					rx -= dx[rd];
					ry -= dy[rd];
					continue;
				} else {
					// 작동을 멈춘다.
					return;
				}
			}
			
			// 주변에 청소가 되지 않은 칸이 있으면
			// 90도씩 반시계방향으로 회전한다.
			// 회전하다가 로봇의 전방에 청소가 되지 않은 칸이 있다면
			// 한 칸 전진하고 1번으로 되돌아간다.
			for (int d = 0 ; d < 4 ; d ++) {
				rd = (rd + 3) % 4; 
				int nx = rx + dx[rd];
				int ny = ry + dy[rd];
				// 다음 부분이 갈 수 있고, 청소가 안되어 있다면
				if (inRange(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					rx = nx;
					ry = ny;
					result++;
					break;
				}
			}
		}
	}
	
	static boolean inRange(int x, int y) { 
		return (x < 0 || y < 0 || x >= n || y >= m) ? false : true;
	}

}