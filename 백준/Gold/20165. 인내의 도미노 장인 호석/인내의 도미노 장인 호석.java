import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int x;
		int y;
		int dir;
		public Node(int x, int  y) {
			this.x = x;
			this.y = y;
			
		}
		public Node(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, r, score;
	static Node[] attack, defend;
	static int[][] map, visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		attack = new Node[r];
		defend = new Node[r];
		
		// map 입력
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// order 입력
		for (int i = 0 ; i < r ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			char input_dir = st.nextToken().charAt(0);
			int dir = -1;
			switch(input_dir) {
			case 'E':
				dir = 0;
				break;
			case 'W':
				dir = 1;
				break;
			case 'S':
				dir = 2;
				break;
			case 'N':
				dir = 3;
				break;
			}
			
			attack[i] = new Node(x, y, dir);
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			defend[i] = new Node(x, y);
		}
		
		// bfs 시작
		for (int i = 0 ; i < r ; i ++) {
			bfs(i);
			// 수비수가 도미노 다시 세우는 과정
			visited[defend[i].x][defend[i].y] = 0;
		}
		
		System.out.println(score);
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j++ ) {
				if (visited[i][j] == 1) {
					System.out.print("F ");
				} else {
					System.out.print("S ");
				}
			}
			System.out.println();
		}
	}
	
	static void bfs(int cur) {
		// 공격수 도미노 무너뜨리기
		ArrayDeque<Node> q = new ArrayDeque<>();
		Node start = attack[cur];
		
		int x = start.x;
		int y = start.y;
		int d = start.dir;
		
		
		if (visited[x][y] == 0) {
			q.add(new Node(x, y, d));
			visited[x][y] = 1;
			score++;
		}
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			int cx = temp.x;
			int cy = temp.y;
			int cd = temp.dir;
			
			int len = map[cx][cy] - 1;
			
			for (int i = 1 ; i <= len ; i ++) {
				int nx = cx + dx[cd] * i;
				int ny = cy + dy[cd] * i;
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 1) {
					continue;
				}
				
				q.add(new Node(nx, ny, cd));
				visited[nx][ny] = 1;
				score ++;
				
			}
		}
	}
}