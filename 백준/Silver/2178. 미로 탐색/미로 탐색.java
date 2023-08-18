import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	
	static int n, m, result;    
	static int[][] Map;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new int[n][m];
		dist = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			
			String temp = br.readLine();
			for (int j = 0 ; j < m ; j ++) {
				Map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0 ; i < n ; i ++)
			Arrays.fill(dist[i], -1);
		
		solve(0, 0);
		System.out.println(dist[n-1][m-1]);
	}
	
	static void solve(int x, int y) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(x, y));
		dist[x][y] = 1; 
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			
			for (int i = 0 ; i < 4; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || dist[nx][ny] != -1
						|| Map[nx][ny] == 0){
					continue;
				}
				
				q.add(new Node(nx, ny));
				dist[nx][ny] = dist[cx][cy] + 1;  
			}
		}
		
	}
}