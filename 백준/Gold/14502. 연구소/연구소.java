import java.io.*;
import java.util.*;

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
	static int n, m, result;
	static int[][] Map;
	static ArrayList<Node> virus;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1 ,1};
	static int[] dy = { 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		Map = new int[n][m];
		virus = new ArrayList<>();
		visited = new boolean[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < m ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if (Map[i][j]== 2) {
					virus.add(new Node(i,j));
				}
			}
		}

		combi(0, 0);
		System.out.println(result);
	}
	
	static void combi(int cnt, int idx) {
		if (cnt == 3) {
			// 맵 복사
			int[][] copyMap = new int[n][m];
			for (int i = 0 ; i < n ; i ++)
			{
				for (int j = 0 ; j < m ; j ++) {
					copyMap[i][j] = Map[i][j]; 
				}
			}
			// bfs
			bfs();
			
			int safe = 0;
			// check Max val
			for (int i = 0 ; i < n ; i ++ ) {
				for (int j = 0 ; j < m ; j ++ ) {
					if (Map[i][j]== 0) {
						safe++;
					}
				}
			}
			
			result = Math.max(safe, result);
			
			for (int i = 0 ; i < n ; i ++)
			{
				for (int j = 0 ; j < m ; j ++) {
					Map[i][j] = copyMap[i][j]; 
				}
			}
			return;
		}
		
		for (int i = idx ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				// 빈칸이라면
				if (Map[i][j] == 0) {
					// 벽 세우기
					Map[i][j] = 1;
					combi(cnt+1, i);
					Map[i][j] = 0; 
				}
			}
		}
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0 ; i < virus.size(); i ++) {
			q.add(new Node(virus.get(i).x, virus.get(i).y));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0 ; i < 4; i ++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
				if (Map[nx][ny] == 1 || Map[nx][ny] == 2) continue;
				
				q.add(new Node(nx, ny));
				Map[nx][ny] = 2; 
				visited[nx][ny] = true;
			}
		}
	}
	
}
