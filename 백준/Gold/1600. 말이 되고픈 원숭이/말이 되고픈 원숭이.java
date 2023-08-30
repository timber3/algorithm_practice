import java.io.*;
import java.util.*;


public class Main {
	
	static class Node {
		int x;
		int y;
		int horse;
		public Node(int x, int y, int horse) {
			super();
			this.x = x;
			this.y = y;
			this.horse = horse;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", horse=" + horse + "]";
		}
		
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] h_dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] h_dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int k, w, h;
	static int[][] Map;
	static int[][][] visited;
	
	public static void main(String[] args) throws IOException {
		
		k = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		Map = new int[h][w];
		visited = new int[h][w][k+1];
		
		for (int i = 0 ; i < h ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < w ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		for (int i = 0 ; i < h ; i ++ ) {
			for (int j = 0 ; j < w ; j ++ ) {
				for (int t = 0 ; t < k+1 ; t ++ ) {
					visited[i][j][t] = -1; 
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, k));
		// visited 에 거리 담기
		visited[0][0][k] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			int ch = cur.horse;
			
			if (cx == h-1 && cy == w-1) {
				return visited[cx][cy][ch];
			}
			
			// 말처럼 갈 수 있으면
			if (ch != 0) {
				for (int i = 0 ; i < 8 ; i ++) {
					int nx = cx + h_dx[i];
					int ny = cy + h_dy[i];
					
					if (nx < 0 || ny < 0 || nx >= h || ny >= w || Map[nx][ny] == 1) {
						continue;
					}
					
					if (visited[nx][ny][ch-1] != -1)
						continue;
					
					q.add(new Node(nx, ny, ch-1));
					visited[nx][ny][ch-1] = visited[cx][cy][ch] + 1;
				}
			}
			
			for (int i = 0 ; i < 4 ; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || Map[nx][ny] == 1) {
					continue;
				}
				
				if (visited[nx][ny][ch] != -1)
					continue;
				
				q.add(new Node(nx, ny, ch));
				visited[nx][ny][ch] = visited[cx][cy][ch] + 1;
			}
			
		}
		
		return -1;
	}
}
