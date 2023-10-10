import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
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
	static char[][] map;
	static int[] dx = { 0 ,0, -1 ,1};
	static int[] dy = { 1 ,-1, 0 ,0};
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		map = new char[12][6];
		
		for (int i = 0 ; i < 12 ; i ++ ) {
			String str = br.readLine();
			
			for (int j = 0 ; j < 6 ; j ++) {
				map[i][j] = str.charAt(j);
			}
		}
		while(findPuyo()) {
			continue;
		}
		System.out.println(result);
	}
    
	static boolean findPuyo() {
		
		boolean flag = false;
		
		for (int i = 0; i < 12 ; i ++ ) {
			for (int j = 0 ; j < 6 ; j++) {
				if (map[i][j] != '.') {
					// 터트린 블럭이 있을 때 중력을 작용 해야 함.
					if (bfs(i, j))
						flag = true;
				}
			}
		}
		
		if (flag) {
			result ++;
			gravity();
			return true;
		} else 
			return false;
	}
	
	static boolean bfs(int x, int y) {
		char ch = map[x][y];
		int cnt = 1;
		
		visited = new boolean[12][6];
        
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0 ; i < 4 ; i ++ ) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == ch) {
					cnt ++;
					q.add(new Node(nx ,ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		if (cnt >= 4)
		{
			for (int i = 0 ; i < 12 ; i ++) {
				for (int j = 0 ; j < 6 ; j ++) {
					if(visited[i][j]) {
						map[i][j] = '.';
					}
				}
			}
			return true;
		}
		
		return false;
	}
	
	static void gravity() {
		
		Queue<Character> q = new LinkedList<>();

		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 11 ; j >= 0  ; j --) {
				if (map[j][i] != '.') {
					q.add(map[j][i]);
					map[j][i] = '.';
				}
			}
			
			int idx = 11;
			while(!q.isEmpty()) {	
				map[idx][i] = q.poll();
				idx--;
			}
		}
	}
	
	
}