import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int n, m, cctv, result = Integer.MAX_VALUE;
	static int[][] Map;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Node> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
				
				Map[i][j] = Integer.parseInt(st.nextToken());
				
				if (Map[i][j] > 0 && Map[i][j] < 6) {
					list.add(new Node(i, j));
					cctv++;
				}
			}
		}
		
		dfs(0);
		
		System.out.println(result);
		
	}
	
	// 감시 범위 = 7
	static void dfs(int cnt) {
		if (cnt == cctv) {
			int count = 0;
			
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j ++) {
					if (Map[i][j] == 0) {
						count ++;
					}
				}
			}
			result = Math.min(result, count);
			return;
		}
		
		// Map 복사
		int[][] temp = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++ ) {
			for (int j = 0 ; j< m ; j ++ ) {
				temp[i][j] = Map[i][j];
			}
		}
		
		Node cur = list.get(cnt);		
		int cx = cur.x;
		int cy = cur.y;
		
		switch (Map[cx][cy]) {
		case 1:
			for (int j = 0 ; j < 4; j ++) {
				observe(cx ,cy, j);
				
				dfs(cnt + 1);
				
				for (int a = 0 ; a < n ; a ++ ) {
					for (int b = 0 ; b< m ; b ++ ) {
						Map[a][b] = temp[a][b];
					}
				}
			}
			break;
		case 2:
			for (int j = 0 ; j < 2; j ++) {
				observe(cx ,cy, j);
				observe(cx, cy, j+2);
				
				dfs(cnt + 1);
				
				for (int a = 0 ; a < n ; a ++ ) {
					for (int b = 0 ; b< m ; b ++ ) {
						Map[a][b] = temp[a][b];
					}
				}
			}
			break;
		case 3:
			for (int j = 0 ; j < 4; j ++) {
				observe(cx ,cy, j);
				observe(cx, cy, ((j+1) % 4));
				
				dfs(cnt + 1);
				
				for (int a = 0 ; a < n ; a ++ ) {
					for (int b = 0 ; b< m ; b ++ ) {
						Map[a][b] = temp[a][b];
					}
				}
			}
			break;
		case 4:
			for (int j = 0 ; j < 4; j ++) {
				observe(cx ,cy, j);
				observe(cx, cy, ((j+1) % 4));
				observe(cx, cy, ((j+2) % 4));
				
				dfs(cnt + 1);
				
				for (int a = 0 ; a < n ; a ++ ) {
					for (int b = 0 ; b< m ; b ++ ) {
						Map[a][b] = temp[a][b];
					}
				}
			}
			break;
		case 5:
			observe(cx ,cy, 0);
			observe(cx, cy, 1);
			observe(cx, cy, 2);
			observe(cx, cy, 3);
			
			dfs(cnt + 1);
			
			for (int a = 0 ; a < n ; a ++ ) {
				for (int b = 0 ; b< m ; b ++ ) {
					Map[a][b] = temp[a][b];
				}
			}
			break;
		}
		
		return;
		
	}
	
	static void observe(int x, int y, int dir) {
		while(true) {						
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || Map[nx][ny] == 6)
				break;
			
			if ( Map[nx][ny] == 0 ) {
				Map[nx][ny] = 7;
			}
			
			x = nx;
			y = ny;
		}
	}
	
}
