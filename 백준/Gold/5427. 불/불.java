import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int tc, n, m;
	static int tx, ty;
	static int result;
	static char[][] map;
	static int[][] fireTime, visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		
		tc = Integer.parseInt(br.readLine());
		
		for (int TC = 0 ; TC < tc ; TC++) {
			
			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			fireTime = new int[n][m];
			visited = new int[n][m];
			
			for (int i = 0 ; i < n ; i++) {
				
				String str = br.readLine();
				for (int j = 0 ; j < m ; j ++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						tx = i;
						ty = j;
					}
				}
			}
			
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j ++) {
					fireTime[i][j] = -1;
				}
			}
			
			fire_bfs();
			
			bfs();
			
			if (result == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
				result = 0;
			}
			
		}
				
	}
	
	static void fire_bfs() {
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		for(int i = 0 ; i < n ; i ++) {
			for( int j = 0 ; j < m ; j ++) {
				// 불이라면
				if (map[i][j] == '*') {
					q.add(new Node(i, j));
					fireTime[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				// 다음 갈 곳이 범위 밖이거나 벽일 경우
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#') {
					continue;
				}
				
				// 다음 갈 곳이 가본 곳인데 현재 + 1 보다 작으면 굳이 갈 필요가 없음.
				if (fireTime[nx][ny] != -1 && fireTime[cx][cy] + 1 >= fireTime[nx][ny]) {
					continue;
				}
				
				// 
				fireTime[nx][ny] = fireTime[cx][cy] + 1;
				q.add(new Node(nx, ny));
				
			}
		}
	}
	
	static void bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(new Node(tx, ty));
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				// 탈출했으면
				if (nx < 0 || ny < 0 || nx >= n || ny >= m ) {
					result = visited[cx][cy] + 1;
					return;
				}
				
				if (visited[nx][ny] != 0 || map[nx][ny] == '#' || (fireTime[nx][ny] != -1 && visited[cx][cy] + 1 >= fireTime[nx][ny]) ) {
					continue;
				}
				
				visited[nx][ny] = visited[cx][cy] + 1;
				q.add(new Node(nx, ny));
				
			}
		}		
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}