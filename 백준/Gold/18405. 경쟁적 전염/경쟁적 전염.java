import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int x;
		int y;
		int v;
		public Node(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	static int n, k, s, tx, ty;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map, visited;
	
	static Queue<Node> pq = new PriorityQueue<>((a, b) -> {
		return a.v - b.v;
	});
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		visited = new int[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					pq.add(new Node(i,j,map[i][j]));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken()); 
		tx = Integer.parseInt(st.nextToken()); 
		ty = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j ++) {
				visited[i][j] = -1;
			}
		}
		
		bfs();
		
		if (visited[tx-1][ty-1] > s) {
			System.out.println(0);
		} else {
			System.out.println(map[tx-1][ty-1]);
		}
		
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		int size = pq.size();
		
		for (int i = 0 ; i < size ; i ++) {
			Node temp = pq.poll();
			visited[temp.x][temp.y] = 0;
			q.add(temp);
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			int cx = cur.x;
			int cy = cur.y;
			int cv = cur.v;
			
			for (int d = 0 ; d < 4 ; d ++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != -1) {
					continue;
				}
				
				q.add(new Node(nx,ny,cv));
				map[nx][ny] = cv;
				visited[nx][ny] = visited[cx][cy] + 1;	
			}
		}
	}

}