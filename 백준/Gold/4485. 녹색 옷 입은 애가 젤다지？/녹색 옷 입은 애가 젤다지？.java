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
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, cnt;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1 };
	static int[] dy = {1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
				
		while(true) {
			cnt ++;
			n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				break;
			}
			
			map = new int[n][n];
			dist = new int[n][n];
			
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					dist[i][j] = 9999;
				}
			}
			
			for (int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0 ; j < n ; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			System.out.printf("Problem %d: %d\n", cnt, dist[n-1][n-1]);
		}
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		dist[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			
			for (int i= 0 ; i < 4; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				
				if (dist[nx][ny] > dist[cx][cy] + map[nx][ny]) {
					q.add(new Node(nx, ny));
					dist[nx][ny] = dist[cx][cy] + map[nx][ny];
				}
			}
		}
		
	}
}