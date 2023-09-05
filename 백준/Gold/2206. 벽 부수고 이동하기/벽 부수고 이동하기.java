import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int x;
		int y;
		boolean crush;
		public Node(int x, int y, boolean crush) {
			super();
			this.x = x;
			this.y = y;
			this.crush = crush;
		}

	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int n, m;
	static int[][] Map;
	static int[][][] visited;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new int[n][m];
		visited = new int[n][m][2];
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j ++) {
				for (int k = 0 ; k < 2 ; k ++) {
					visited[i][j][k] = -1;
				}
			}
		}
		
		for (int i = 0 ; i < n ; i ++ ) {
			String str = br.readLine();
			for (int j = 0 ; j < m ; j ++) {
				Map[i][j]= str.charAt(j) - '0';
			}
		}
	
		bfs();
		
		int a = visited[n-1][m-1][0];
		int b = visited[n-1][m-1][1];
		
		int val = -1;
		
		if (a == -1 && b == -1) {
			System.out.println(-1);
			return;
		} else if( a != -1 && b != -1) {
		
			System.out.println(Math.min(a, b)+1);
			return;
		}
		else {
			if (a == -1) {
				System.out.println(b + 1);
				return;
			} else {
				System.out.println(a + 1);
				return;
			}
					
		}
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>(); 
		visited[0][0][0] = 0;
		q.add(new Node(0, 0, false));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			boolean cc = cur.crush;
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m ) {
					continue;
				}
				
				// 다음 갈 곳이 벽이면
				if (Map[nx][ny]==1) {
					// 벽을 부순적이 없으면
					if (!cc) {
						// 방문되지 않은 곳이라면
						if (visited[nx][ny][1] == -1) {
							visited[nx][ny][1] = visited[cx][cy][0] + 1 ;
							q.add(new Node(nx, ny, true));
						}
					}
				}
				// 다음 갈 곳이 벽이 아니면 그냥 가기

				else {
					// 벽을 부순적이 있으면
					if (cc) {
						if(Map[nx][ny]== 0 && visited[nx][ny][1] == -1) {
							visited[nx][ny][1] = visited[cx][cy][1] + 1;
							q.add(new Node(nx, ny, true));
						}
					} 
					// 벽을 부순 적이 없으면
					else {
						if(Map[nx][ny]== 0 && visited[nx][ny][0] == -1) {
							visited[nx][ny][0] = visited[cx][cy][0] + 1;
							q.add(new Node(nx, ny, false));
						}
					}
					
				}
				
			}
		}
	}
	
}

